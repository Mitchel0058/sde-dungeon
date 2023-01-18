package player;

public class Player {
    private int hp = 100;
    private int attack = 30;

    private int block = 30;
    private int heal = 30;

    public void death(){
        System.out.println("You died!");
    }

    public void heal(int amount){
        hp += amount;
    }

    public void damage(int amount){
        hp -= amount;

        if (hp >= 0){
            death();
        }
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

}
