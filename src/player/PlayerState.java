package player;

public interface PlayerState {

    int attack();

    void takeDamage(int amount);

    void heal();
}
