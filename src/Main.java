import builder.*;
import player.*;
import enemy.*;

public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        StringToIntAdapter stringToIntAdapter = new StringToIntAdapter();

        Dungeon dungeon = new Dungeon();
        Pirates pirates = new Pirates();
        Cyber cyber = new Cyber();
        TextDirector textDirector = new TextDirector(dungeon);


        startupSettings(reader, writer, stringToIntAdapter, dungeon, pirates, cyber, textDirector);

        Player player = new Player();
        PlayerState playerAttack = new PlayerAttack(player);
        PlayerState playerBlock = new PlayerBlock(player);
        PlayerState playerHeal = new PlayerHeal(player);

        Enemy enemy = new Enemy();
        EnemyStrategy difficulty1 = new Difficulty1();
        EnemyStrategy difficulty2 = new Difficulty2(player);
        EnemyStrategy difficulty3 = new Difficulty3(player, enemy);
        enemy.setEnemyStrategy(difficulty3);
        int defeatedEnemies = 0;

        while (player.isAlive()) {
            writer.write("A new enemy appears!");
            Battle(reader, writer, stringToIntAdapter, player, playerAttack, playerBlock, playerHeal, enemy, textDirector);
            if (!enemy.isAlive()) {
                defeatedEnemies += 1;
                enemy = new Enemy();
                if (defeatedEnemies > 1) {
                    enemy.setEnemyStrategy(difficulty3);
                } else if (defeatedEnemies > 0) {
                    enemy.setEnemyStrategy(difficulty2);
                }
            }
            writer.write("\r\nYou've defeated " + defeatedEnemies + " enemies!");
        }
    }

    private static void Battle(ConsoleReader reader, ConsoleWriter writer, StringToIntAdapter stringToIntAdapter, Player player, PlayerState playerAttack, PlayerState playerBlock, PlayerState playerHeal, Enemy enemy, TextDirector textDirector) {
        int ans;
        while (player.isAlive() && enemy.isAlive()) {
            writer.write("Player hp: " + player.getHp() + " Enemy hp: " + enemy.getHp() + "\r\n" + "[1] Attack \r\n" + "[2] Block \r\n" + "[3] Heal");
            System.out.println();

            ans = stringToIntAdapter.adaptString(reader.readLine(), 3);
            while (ans == 0) {
                writer.write("I did not understand");
                ans = stringToIntAdapter.adaptString(reader.readLine(), 3);
            }
            if (ans == 1) {
                player.changeState(playerAttack);
            } else if (ans == 2) {
                player.changeState(playerBlock);
            } else if (ans == 3) {
                player.changeState(playerHeal);
            }

            int playerDamage = player.attack();
            int playerHealing = player.getHeal();
            int playerBlocking = player.getBlock();
            int enemyDamage = enemy.getAttack();
            int enemyHealing = enemy.getHeal();
            int enemyHealth = enemy.getHp();
            int enemyBlocking = enemy.getBlock();

            int enemyStrategy = enemy.executeStrategy();
            if (enemyStrategy == 0) {
                player.takeDamage(enemyDamage);
                enemy.setHp(enemyHealth - playerDamage);
                player.heal();
            } else if (enemyStrategy == 1) {
                enemy.setHp((int) (enemyHealth - (playerDamage * 0.5)));
                player.heal();
            } else if (enemyStrategy == 2) {
                enemy.setHp(enemyHealth - playerDamage);
                enemy.setHp(enemy.getHp() + enemyHealing);
                player.heal();
            } else {
                System.out.println("Something went wrong, enemy somehow chose strategy: " + enemyStrategy);
            }

//            Would like to do this differently, but for now this will suffice. At least switch is clearer here than if.
            switch (ans) {
                case (1) -> {
                    switch (enemyStrategy) {
                        case (0) -> writer.write(textDirector.bothAttack(playerDamage, enemyDamage));
                        case (1) -> writer.write(textDirector.playerAttackEnemyBlock(playerDamage, enemyBlocking));
                        case (2) -> writer.write(textDirector.playerAttackEnemyHeal(playerDamage, enemyHealing));
                    }
                }
                case (2) -> {
                    switch (enemyStrategy) {
                        case (0) -> writer.write(textDirector.playerBlockEnemyAttack(playerBlocking, enemyDamage));
                        case (1) -> writer.write(textDirector.bothBlock(playerBlocking, enemyBlocking));
                        case (2) -> writer.write(textDirector.playerBlockEnemyHeal(playerBlocking, enemyHealing));
                    }
                }
                case (3) -> {
                    switch (enemyStrategy) {
                        case (0) -> writer.write(textDirector.playerHealEnemyAttack(playerHealing, enemyDamage));
                        case (1) -> writer.write(textDirector.playerHealEnemyBlock(playerHealing, enemyBlocking));
                        case (2) -> writer.write(textDirector.bothHeal(playerHealing, enemyHealing));
                    }
                }
            }
        }

    }


    private static void startupSettings(ConsoleReader reader, ConsoleWriter writer, StringToIntAdapter stringToIntAdapter, Dungeon dungeon, Pirates pirates, Cyber cyber, TextDirector textDirector) {
        writer.write("""
                Welcome, brave adventurer to this dark dungeon. Are you ready?\s
                [1] Yes!\s
                [2] No!""");

        int ans = stringToIntAdapter.adaptString(reader.readLine(), 2);

        if (ans == 2) {
            writer.write("Well fine. Goodbye then.");
            System.exit(0);
        }
        while (ans == 0) {
            writer.write("I'm sorry, I did not understand that.");
            ans = stringToIntAdapter.adaptString(reader.readLine(), 2);
            if (ans == 2) {
                writer.write("Well fine. Goodbye then.");
                System.exit(0);
            }
        }

        writer.write("""
                Which adventure do you wish to go on?\s
                [1] Dungeon\s
                [2] Pirates\s
                [3] Cyber""");

        ans = stringToIntAdapter.adaptString(reader.readLine(), 3);

        while (ans == 0) {
            writer.write("Try again");
            ans = stringToIntAdapter.adaptString(reader.readLine(), 3);
        }

        if (ans == 1) {
            writer.write("You enter a dark crypt.");
            textDirector.Changebuilder(dungeon);
        } else if (ans == 2) {
            writer.write("Yarr boardin' a mighty battalion.");
            textDirector.Changebuilder(pirates);
        } else if (ans == 3) {
            writer.write("You enter the training room");
            textDirector.Changebuilder(cyber);
        }
    }
}