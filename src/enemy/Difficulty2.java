package enemy;

import player.*;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Chooses an action depending on the player's previous action
 * Game is shitty enough that this almost ends in a stalemate
 */
public class Difficulty2 implements EnemyStrategy {
    private int strategy;
    private Player player;
    private int previousPlayerState;

    public Difficulty2(Player player) {
        this.player = player;
    }

    @Override
    public int execute() {
        String playerStateName = player.getPlayerState().getClass().getName();

//        Attack or heal if player previously attacked
        if (previousPlayerState == 0) {
            if (ThreadLocalRandom.current().nextInt(0, 2) == 0) {
                strategy = 0;
            } else {
                strategy = 2;
            }
//            Attack if player previously blocked or healed, in the current version blocking is pointless
        } else {
            strategy = 0;
        }

        switch (playerStateName) {
            case "player.PlayerAttack" -> previousPlayerState = 0;
            case "player.PlayerDefend" -> previousPlayerState = 1;
            case "player.PlayerHeal" -> previousPlayerState = 2;
        }

        return strategy;
    }
}
