package enemy;
import player.PlayerState;

/**
 * Chooses an action depending on the player's previous action
 */
public class Difficulty2 implements EnemyStrategy {
    private int strategy;

    private PlayerState playerPreviousStrategy;

    @Override
    public int execute() {


        strategy = 1;

        return strategy;
    }
}
