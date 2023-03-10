package player;

public class PlayerHeal implements PlayerState {
    Player player;

    public PlayerHeal(Player player) {
        this.player = player;
    }

    @Override
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
}
