package player;

import java.util.concurrent.ThreadLocalRandom;


public class PlayerAttack implements PlayerState {
    Player player;

    public PlayerAttack(Player player) {
        this.player = player;
    }

    /**
     * Attacks, with an additional or reduced 20% damage
     *
     * @return the attack value
     */
    @Override
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
}
