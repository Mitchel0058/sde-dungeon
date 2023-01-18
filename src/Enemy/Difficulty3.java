package Enemy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Cheats by looking at the player's current action. Unwinnable.
 */
public class Difficulty3 implements EnemyStrategy {
    private int strategy;

    @Override
    public int execute() {

        strategy = 2;

        return strategy;
    }
}
