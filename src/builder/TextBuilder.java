package builder;

public interface TextBuilder {
    String getText();

    void reset();
    void dealtDamage(String damage);
    void tookDamage(String damage);
    void healed(String healing);
    void shield(String shielding);
    void enemyHealed(String healing);
    void enemyShielding(String shielding);
}
