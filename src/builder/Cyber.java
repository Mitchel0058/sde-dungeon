package builder;

public class Cyber implements TextBuilder{
    private String text;

    @Override
    public String getText() {
        return text;
    }

    public void reset(){text = "";}

    @Override
    public void dealtDamage(String damage) {
        text += "You dealt " + damage + " damage.";
        addNewLine();
    }

    @Override
    public void tookDamage(String damage) {
        text += "You took " + damage + " damage.";
        addNewLine();
    }

    @Override
    public void healed(String healing) {
        text += "You healed for " + healing + " hp.";
        addNewLine();
    }

    @Override
    public void shield(String shielding) {
        text += "You blocked " + shielding + " damage.";
        addNewLine();
    }

    private void addNewLine(){
        text += "\n\r";
    }
}
