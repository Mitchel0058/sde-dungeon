import java.util.Objects;

public class StringToIntAdapter {

    public int adaptString(String string) {
        string = string.toLowerCase();

        for (int i = 0; i < 9; i++) {
            if (Objects.equals(string, "" + i)) {
                return i;
            }
        }

        String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < numbers.length; i++) {
            if (Objects.equals(string, numbers[0])) {
                return i;
            }
        }

        return 0;
    }
}

