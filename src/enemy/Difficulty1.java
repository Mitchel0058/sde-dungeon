package enemy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Randomly picks an action
 */
public class Difficulty1 implements EnemyStrategy {

    @Override
    public int execute() {
        return ThreadLocalRandom.current().nextInt(0, 3);
    }
}
