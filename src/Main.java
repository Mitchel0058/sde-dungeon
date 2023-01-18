import builder.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        StringToIntAdapter stringToIntAdapter = new StringToIntAdapter();

//        for (int i = 0; i < 99; i++){
//            System.out.println(ThreadLocalRandom.current().nextInt(80, 121));
//        }

        Dungeon dungeon = new Dungeon();
        Pirates pirates = new Pirates();
        Cyber cyber = new Cyber();
        TextDirector textDirector = new TextDirector(dungeon);

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

        writer.write(textDirector.makeBattleText());
    }
}