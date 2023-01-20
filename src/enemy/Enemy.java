package enemy;

public class Enemy {
    private EnemyStrategy enemyStrategy;

    private int hp = 100;
    private int attack = 30;
    private int block = 30;
    private int heal = 30;
    private boolean alive = true;

    public void setEnemyStrategy(EnemyStrategy enemyStrategy) {
        this.enemyStrategy = enemyStrategy;
    }

    public int executeStrategy() {
        return enemyStrategy.execute();
    }

    public void death(){
        System.out.println("Enemy slain!");
        alive = false;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        if (this.hp <= 0){
            death();
        }
    }

    public boolean isAlive() {
        return alive;
    }
}
