package player;

public class PlayerBlock implements PlayerState {
    Player player;

    public PlayerBlock(Player player) {
        this.player = player;
    }

    @Override
    public void takeDamage(int amount) {
        amount *= ((double) player.getBlock() / 100);

        player.setHp(player.getHp() - amount);
        if (player.getHp() >= 0) {
            player.death();
        }
    }

    @Override
    public void heal(int amount) {

    }
}
