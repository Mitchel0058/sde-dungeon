package Enemy;
import player.Player;

public class Enemy {
    private EnemyStrategy enemyStrategy;

    public void setEnemyStrategy(EnemyStrategy enemyStrategy){
        this.enemyStrategy = enemyStrategy;
    }

    public void executeStrategy(){
        enemyStrategy.execute();
    }
}
