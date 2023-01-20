package builder;


public class TextDirector {

    private TextBuilder textBuilder;

    public TextDirector(TextBuilder builder) {
        textBuilder = builder;
    }

    public void Changebuilder(TextBuilder builder) {
        textBuilder = builder;
    }

    /**
     * Was made for testing
     *
     * @return the text of a fake battle
     */
    public String makeFakeBattleText() {
        textBuilder.reset();
        textBuilder.dealtDamage("75");
        textBuilder.tookDamage("60");
        textBuilder.healed("25");
        textBuilder.tookDamage("20");
        textBuilder.shield("100");
        textBuilder.tookDamage("10");

        return textBuilder.getText();
    }

    public String bothAttack(int playerAttack, int enemyAttack) {
        textBuilder.reset();
        textBuilder.dealtDamage("" + playerAttack);
        textBuilder.tookDamage("" + enemyAttack);

        return textBuilder.getText();
    }

    public String bothHeal(int playerHeal, int enemyHeal) {
        textBuilder.reset();
        textBuilder.healed("" + playerHeal);
        textBuilder.enemyHealed("" + enemyHeal);

        return textBuilder.getText();
    }

    public String bothBlock(int playerBlock, int enemyBlock) {
        textBuilder.reset();
        textBuilder.shield("" + playerBlock);
        textBuilder.enemyShielding("" + enemyBlock);

        return textBuilder.getText();
    }
}
