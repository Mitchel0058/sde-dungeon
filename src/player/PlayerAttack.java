package player;

import java.util.concurrent.ThreadLocalRandom;


public class PlayerAttack implements PlayerState {
    Player player;

    public PlayerAttack(Player player) {
        this.player = player;
    }

    @Override
    public int attack() {
        return player.getAttack();
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
