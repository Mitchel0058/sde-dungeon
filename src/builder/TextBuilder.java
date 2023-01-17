package builder;

public interface TextBuilder {

    void reset();
    void dealtDamage(int damage);
    void tookDamage(int damage);
    void healed(int healing);
    void shield(int shielding);
}
