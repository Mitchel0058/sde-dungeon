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
        text += "Your nano machines healed you for " + healing + " hp.";
        addNewLine();
    }

    @Override
    public void shield(String shielding) {
        text += "Your nano machines blocked you from " + shielding + "% damage.";
        addNewLine();
    }

    @Override
    public void enemyHealed(String healing) {
        text += "The enemies' nano machine started working. They healed for " + healing + "hp.";
    }

    @Override
    public void enemyShielding(String shielding) {
        text += "The enemies' nano machine are protecting them. They blocked for " + shielding + "%.";
    }

    private void addNewLine(){
        text += "\n\r";
    }
}
