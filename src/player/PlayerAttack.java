package player;

import java.util.concurrent.ThreadLocalRandom;


public class PlayerAttack implements PlayerState {
    Player player;

    public PlayerAttack(Player player) {
        this.player = player;
    }

    @Override
    public void takeDamage(int amount) {
        if (ThreadLocalRandom.current().nextInt(0, 4) == 0) {
            System.out.println("Your attacks clashed!");
            return;
        }

        player.setHp(player.getHp() - amount);
        if (player.getHp() >= 0) {
            player.death();
        }
    }

    @Override
    public void heal(int amount) {

    }
}
