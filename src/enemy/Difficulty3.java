package enemy;

import player.Player;

/**
 * Cheats by looking at the player's current action.
 * If the player attacks the enemy attacks.
 * If the player heals the enemy attacks.
 * If the player blocks it heals if it is below 50hp, otherwise it attacks.
 */
public class Difficulty3 implements EnemyStrategy {
    private int strategy;
    private Player player;
    private Enemy enemy;
    private int playerState;

    public Difficulty3(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    @Override
    public int execute() {
        String playerStateName = player.getPlayerState().getClass().getName();

        switch (playerStateName) {
            case "player.PlayerAttack" -> playerState = 0;
            case "player.PlayerBlock" -> playerState = 1;
            case "player.PlayerHeal" -> playerState = 2;
        }

//        If player blocks, if hp < 50 heal else attack, all other cases attack
        if (playerState == 1) {
            if (enemy.getHp() < 50) {
                strategy = 2;
            }
        } else {
            strategy = 0;
        }

        return strategy;
    }
}
