package builder;


public class TextDirector {

    private TextBuilder textBuilder;

    public TextDirector(TextBuilder builder) {
        textBuilder = builder;
    }

    public void Changebuilder(TextBuilder builder) {
        textBuilder = builder;
    }

    public String makeBattleText() {
        textBuilder.reset();
        textBuilder.dealtDamage("75");
        textBuilder.tookDamage("60");
        textBuilder.healed("25");
        textBuilder.tookDamage("20");
        textBuilder.shield("100");
        textBuilder.tookDamage("10");

        return textBuilder.getText();
    }

}
