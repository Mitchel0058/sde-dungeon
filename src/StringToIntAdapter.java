import java.util.Objects;

public class StringToIntAdapter {

    public int adaptString(String string, int options) {
        string = string.toLowerCase();

//        Makes sure gibberish isn't send but an actual number
        for (int i = 0; i <= options; i++) {
            if (Objects.equals(string, "" + i)) {
                return i;
            }
        }

//        If I ever add a question for more than nine options I could increase this, but for now this is enough.
//        Above nine you probably won't type it out anyways
        String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < options; i++) {
            if (Objects.equals(string, numbers[i])) {
                return i + 1;
            }
        }

        return 0;
    }
}
