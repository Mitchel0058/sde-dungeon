# sde-dungeon

Link to the GitHub: https://github.com/Mitchel0058/sde-dungeon.
I equally distributed the work between me, myself, and I. As can be seen from the commits.

## Creational:

### Builder

The builder pattern is used in from the builder folder. At the start you get asked what kind of adventure you want to
go on, this sets up which builder will be used. At the moment there are three builders: Cyber, Dungeon, and Pirates
which all display the text slightly differently. The TextDirector doesn't use that many of the builder's function
together in one function, due to there not being any large text that need to be made. If there were longer texts
required more would be used.

TextDirector example:

```
public String bothAttack(int playerAttack, int enemyAttack) {
        textBuilder.reset();
        textBuilder.dealtDamage("" + playerAttack);
        textBuilder.tookDamage("" + enemyAttack);

        return textBuilder.getText();
    }
```

Pirates example:

```
    public void dealtDamage(String damage) {
        text += "Yarr scabbard hit em for a " + damage + ".";
        addNewLine();
    }

    @Override
    public void tookDamage(String damage) {
        text += "Thar scallywag slashed ye for " + damage + " damage.";
        addNewLine();
    }
```

TextBuilder interface:

```
public interface TextBuilder {
    String getText();

    void reset();
    void dealtDamage(String damage);
    void tookDamage(String damage);
    void healed(String healing);
    void shield(String shielding);
    void enemyHealed(String healing);
    void enemyShielding(String shielding);
}
```

## Structural:

### Adapter

The adapter is used in the StringToIntAdapter. First it simply checks any number (1, 2, 3, etc.) if it's equivalent.
This normally isn't necessary since you can simply make a string of only a number into a string, however it also
limits it to the amount of options provided. Afterwards it also checks if you typed out the number, such as one, two,
three. If it recognizes it then it returns the int, otherwise it returns 0, which indicates it didn't recognize any,
or
it was outside the options range.

```
    public int adaptString(String string, int options) {
        string = string.toLowerCase();

//        Makes sure gibberish isn't send but an actual number
        for (int i = 0; i <= options; i++) {
            if (Objects.equals(string, "" + i)) {
                return i;
            }
        }

//        If I ever add a question for more than nine options I could increase this, but for now this is enough.
//        Above nine you probably won't type it out anyways
        String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < options; i++) {
            if (Objects.equals(string, numbers[i])) {
                return i + 1;
            }
        }

        return 0;
    }
```

## Behavioral:

### State

The state design pattern is used by the player. It can be in three states: attacking, defending, healing.  
When it's attacking the attack function returns his attack value +/- 20%. The healing functions does nothing in this
state. And in the takeDamage function there's a 25% chance to not take damage.

```
public int attack() {
        int attackDiscrepant = ThreadLocalRandom.current().nextInt(80, 121);
        return (int) (player.getAttack() * ((double) attackDiscrepant / 100));
    }

    @Override
    public void takeDamage(int amount) {
        if (ThreadLocalRandom.current().nextInt(0, 4) == 0) {
            System.out.println("You overwhelmed the enemy with your sword fighting skills!");
            return;
        }

        player.setHp(player.getHp() - amount);
        if (player.getHp() <= 0) {
            player.death();
        }
    }

    @Override
    public void heal() {

    }
```

When it's in the blocking state the attack and healing functions do nothing, but the takeDamage reduces his damage
taken by the block value in a percentage.

```
public int attack() {
        return 0;
    }

    @Override
    public void takeDamage(int amount) {
        amount *= ((double) player.getBlock() / 100);

        player.setHp(player.getHp() - amount);
        if (player.getHp() <= 0) {
            player.death();
        }
    }

    @Override
    public void heal() {

    }
```

When it's in the healing state attacking does nothing, take damage is increased by 10% and healing heals it for the
healing amount.

```
public int attack() {
        return 0;
    }

    @Override
    public void takeDamage(int amount) {
        amount *= 1.1;

        player.setHp(player.getHp() - amount);
        if (player.getHp() <= 0) {
            player.death();
        }
    }

    @Override
    public void heal() {
        player.setHp(player.getHp() + player.getHeal());
    }
```

I would've liked to apply this to the enemy as well, but wasn't able to do so in time.

### Strategy

The enemy uses a strategy. The strategy is decided by the amount of enemies defeated. Default is Difficulty1 when you
haven't killed any yet, one kill is Difficulty 2 and onwards is Difficulty3.

In Difficulty1 the enemy randomly chooses to attack, block, or heal.

```
public int execute() {
        return ThreadLocalRandom.current().nextInt(0, 3);
    }
```

In Difficulty2 the enemy looks at your previous action and decides what to do then.

```
public int execute() {
        String playerStateName = player.getPlayerState().getClass().getName();

//        Attack or heal if player previously attacked
        if (previousPlayerState == 0) {
            if (ThreadLocalRandom.current().nextInt(0, 2) == 0) {
                strategy = 0;
            } else {
                strategy = 2;
            }
//            Attack if player previously blocked or healed, in the current version blocking is pointless
        } else {
            strategy = 0;
        }

        switch (playerStateName) {
            case "player.PlayerAttack" -> previousPlayerState = 0;
            case "player.PlayerBlock" -> previousPlayerState = 1;
            case "player.PlayerHeal" -> previousPlayerState = 2;
        }

        return strategy;
    }
```

In Difficulty3 the enemy looks at what you are doing and then acts, effectively cheating.

```
    public int execute() {
        String playerStateName = player.getPlayerState().getClass().getName();

        switch (playerStateName) {
            case "player.PlayerAttack" -> playerState = 0;
            case "player.PlayerBlock" -> playerState = 1;
            case "player.PlayerHeal" -> playerState = 2;
        }

//        If player blocks, if hp < 50 heal else attack, all other cases attack
        if (playerState == 1) {
            if (enemy.getHp() < 50) {
                strategy = 2;
            }
        } else {
            strategy = 0;
        }

        return strategy;
    }
```

This is activated from the enemy class.

```
public int executeStrategy() {
        return enemyStrategy.execute();
    }
```

## Things I'd like to change

- Make the enemies also use states, would make the battle easier to code.
- Make an actual battle class instead of it being a function in Main.
- Have more than just battles.
- Have the block not be useless, perhaps by it stunning you if you hit it.
- Have more interesting stats than just 100 hp, 30 attack, 30 block, 30 heal.
- Have more interesting things to do than just attack, block, heal. Though for now these basics suffice quite well.
