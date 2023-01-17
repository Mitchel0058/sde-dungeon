import builder.TextBuilder;
public class Main {
    public static void main(String[] args) {

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        StringToIntAdapter stringToIntAdapter = new StringToIntAdapter();

        writer.write("""
                Welcome, brave adventurer to this dark dungeon. Are you ready?\s
                [1] Yes!\s
                [2] No!""");

        int ans = stringToIntAdapter.adaptString(reader.readLine());

        if (ans == 2){
            writer.write("Well fine. Goodbye then.");
        }
    }
}