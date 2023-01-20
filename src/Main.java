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
        enemy.setEnemyStrategy(difficulty1);
        int defeatedEnemies = 0;

        while (player.isAlive()) {
            writer.write("A new enemy appears!");
            Battle(reader, writer, stringToIntAdapter, player, playerAttack, playerBlock, playerHeal, enemy);
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

    private static void Battle(ConsoleReader reader, ConsoleWriter writer, StringToIntAdapter stringToIntAdapter, Player player, PlayerState playerAttack, PlayerState playerBlock, PlayerState playerHeal, Enemy enemy) {
        int ans = 0;
        while (player.isAlive() && enemy.isAlive()) {
            writer.write("Player hp: " + player.getHp() + " Enemy hp: " + enemy.getHp() + "\r\n" + "[1] Attack \r\n" + "[2] Block \r\n" + "[3] Heal");
            System.out.println();

            ans = stringToIntAdapter.adaptString(reader.readLine(), 3);
            while (ans == 0) {
                writer.write("I did not understand");
                ans = stringToIntAdapter.adaptString(reader.readLine(), 3);
            }
            if (ans == 1) {
                writer.write("Attacking!");
                player.changeState(playerAttack);
            } else if (ans == 2) {
                writer.write("Blocking!");
                player.changeState(playerBlock);
            } else if (ans == 3) {
                writer.write("Healing!");
                player.changeState(playerHeal);
            }

            int enemyStrategy = enemy.executeStrategy();
            if (enemyStrategy == 0) {
                System.out.println("The enemy attacks!");
                player.takeDamage(enemy.getAttack());
                enemy.setHp(enemy.getHp() - player.attack());
                player.heal();
            } else if (enemyStrategy == 1) {
                System.out.println("The enemy blocks!");
                enemy.setHp((int) (enemy.getHp() - (player.attack() * 0.5)));
                player.heal();
            } else if (enemyStrategy == 2) {
                System.out.println("The enemy heals!");
                enemy.setHp(enemy.getHp() - player.attack());
                enemy.setHp(enemy.getHp() + enemy.getHeal());
                player.heal();
            } else {
                System.out.println("Something went wrong, enemy somehow chose startegy: " + enemyStrategy);
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