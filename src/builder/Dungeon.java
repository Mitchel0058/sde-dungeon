package builder;

public class Dungeon implements TextBuilder {

    private String text;

    @Override
    public String getText() {
        return text;
    }

    public void reset(){text = "";}

    @Override
    public void dealtDamage(String damage) {
        text += "Your sword slashed them for " + damage + " damage.";
        addNewLine();
    }

    @Override
    public void tookDamage(String damage) {
        text += "You got slashed for " + damage + " damage.";
        addNewLine();
    }

    @Override
    public void healed(String healing) {
        text += "You cast a healing spell healing for " + healing + " hp.";
        addNewLine();
    }

    @Override
    public void shield(String shielding) {
        text += "Your shield protected you for from " + shielding + "% damage.";
        addNewLine();
    }

    @Override
    public void enemyHealed(String healing) {
        text += "The enemies' flesh grew back, healing them for " + healing + "hp.";
        addNewLine();
    }

    @Override
    public void enemyShielding(String shielding) {
        text += "The enemies blocked your attack with its thick flesh, blocking for " + shielding + "%";
        addNewLine();
    }

    private void addNewLine(){
        text += "\n\r";
    }

}
