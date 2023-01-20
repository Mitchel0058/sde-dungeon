package player;

import java.util.concurrent.ThreadLocalRandom;

public class Player {
    PlayerState playerState;
    private int hp = 100;
    private int attack = 30;
    private int block = 30;
    private int heal = 30;
    private boolean alive = true;

    public PlayerState getPlayerState() {
        return playerState;
    }
    public void changeState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public int attack() {
        return playerState.attack();
    }

    public void takeDamage(int amount) {
        playerState.takeDamage(amount);
    }

    public void heal() {
        playerState.heal();
    }

    public void death() {
        System.out.println("You died!");
        alive = false;
    }

    //    All get/set values
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
    }

    public boolean isAlive() {
        return alive;
    }
}
