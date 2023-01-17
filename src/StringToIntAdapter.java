import java.util.Objects;

public class StringToIntAdapter {

    public int adaptString(String string) {
        for (int i = 0; i < 5; i++) {
            if(Objects.equals(string, "" + i)) {
            return i;
            }
        }
        return 0;
    }
}

