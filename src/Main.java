import builder.TextDirector;
import builder.Example;

public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        StringToIntAdapter stringToIntAdapter = new StringToIntAdapter();

        Example example = new Example();

        TextDirector textDirector = new TextDirector(example);


        writer.write("""
                Welcome, brave adventurer to this dark dungeon. Are you ready?\s
                [1] Yes!\s
                [2] No!""");

        int ans = stringToIntAdapter.adaptString(reader.readLine());

        if (ans == 2) {
            writer.write("Well fine. Goodbye then.");
            System.exit(0);
        }
        while (ans == 0) {
            writer.write("I'm sorry, I did not understand that.");
            ans = stringToIntAdapter.adaptString(reader.readLine());
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

        ans = stringToIntAdapter.adaptString(reader.readLine());


        writer.write(textDirector.makeBattleText());

    }
}