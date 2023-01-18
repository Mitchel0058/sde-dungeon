package builder;

public class Pirates implements TextBuilder{

    private String text;

    @Override
    public String getText() {
        return text;
    }

    public void reset(){text = "";}

    @Override
    public void dealtDamage(String damage) {
        text += "Yarr scabbard hit em for a " + damage + ".";
        addNewLine();
    }

    @Override
    public void tookDamage(String damage) {
        text += "Yarr took  " + damage + " pains.";
        addNewLine();
    }

    @Override
    public void healed(String healing) {
        text += "Yarr orange fixed " + healing + " scurvy.";
        addNewLine();
    }

    @Override
    public void shield(String shielding) {
        text += "Yarrr shielded " + shielding + " damage.";
        addNewLine();
    }

    private void addNewLine(){
        text += "\n\r";
    }
}
