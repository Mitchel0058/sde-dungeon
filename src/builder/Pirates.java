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
        text += "Thar scallywag slashed ye for " + damage + " damage.";
        addNewLine();
    }

    @Override
    public void healed(String healing) {
        text += "Yarr orange fixed " + healing + " scurvy.";
        addNewLine();
    }

    @Override
    public void shield(String shielding) {
        text += "Yarrr shielded, reducing damage by " + shielding + "%.";
        addNewLine();
    }

    @Override
    public void enemyHealed(String healing) {
        text += "Thar scallywag be eating oranges, making em " + healing + "hp fitter";
        addNewLine();
    }

    @Override
    public void enemyShielding(String shielding) {
        text += "Thar scallywag got a buckler! He be fending for " + shielding + "%!";
        addNewLine();
    }

    private void addNewLine(){
        text += "\n\r";
    }
}
