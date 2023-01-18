import java.util.Objects;

public class StringToIntAdapter {

    public int adaptString(String string, int options) {
        string = string.toLowerCase();

        for (int i = 0; i <= options; i++) {
            if (Objects.equals(string, "" + i)) {
                return i;
            }
        }

//        Unlikely that someone will type out something higher than nine in letters.
        String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i <= options; i++) {
            if (Objects.equals(string, numbers[0])) {
                return i;
            }
        }

        return 0;
    }
}

