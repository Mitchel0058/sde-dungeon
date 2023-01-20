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

    public String playerAttackEnemyBlock(int playerAttack, int enemyBlock){
        textBuilder.reset();
        textBuilder.dealtDamage("" + playerAttack);
        textBuilder.enemyShielding("" + enemyBlock);

        return textBuilder.getText();
    }

    public String playerAttackEnemyHeal(int playerAttack, int enemyHeal){
        textBuilder.reset();
        textBuilder.dealtDamage("" + playerAttack);
        textBuilder.enemyHealed("" + enemyHeal);

        return textBuilder.getText();
    }

    public String playerBlockEnemyAttack(int playerBlock, int enemyAttack){
        textBuilder.reset();
        textBuilder.shield("" + playerBlock);
        textBuilder.tookDamage("" + enemyAttack);

        return textBuilder.getText();
    }

    public String playerBlockEnemyHeal(int playerBlock, int enemyHeal){
        textBuilder.reset();
        textBuilder.shield("" + playerBlock);
        textBuilder.enemyHealed("" + enemyHeal);

        return textBuilder.getText();
    }

    public String playerHealEnemyAttack(int playerHeal, int enemyAttack){
        textBuilder.reset();
        textBuilder.healed("" + playerHeal);
        textBuilder.tookDamage("" + enemyAttack);

        return  textBuilder.getText();
    }

    public String playerHealEnemyBlock(int playerHeal, int enemyBlock){
        textBuilder.reset();
        textBuilder.healed("" + playerHeal);
        textBuilder.enemyShielding("" + enemyBlock);

        return textBuilder.getText();
    }
}
