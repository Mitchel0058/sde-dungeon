package player;

public class PlayerBlock implements PlayerState {
    Player player;

    public PlayerBlock(Player player) {
        this.player = player;
    }

    @Override
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
}
