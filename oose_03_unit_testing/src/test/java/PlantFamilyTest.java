import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantFamilyTest {

    PlantFamily plantFamily = new PlantFamily("leafy", 1, 10, 1);

    @Test
    void getMaxCharges() {
        assertEquals(1, plantFamily.getMaxCharges());
    }

    @Test
    void getCharges() {
        assertEquals(1, plantFamily.getCharges());
    }

    @Test
    void levelUpHealth() {
        plantFamily.levelUp();
        assertEquals(10, plantFamily.getCurrentHealth());
    }

    @Test
    void levelUpLevel() {
        plantFamily.levelUp();
        assertEquals(2, plantFamily.getMonsterLevel());
    }

    @Test
    void levelUpMaxCharges() {
        plantFamily.levelUp();
        assertEquals(2, plantFamily.getMaxCharges());
    }

    @Test
    void takeDamagePlant() {
        plantFamily.takeDamage(new Damage(DamageType.PLANT, 6));
        assertEquals(7, plantFamily.getCurrentHealth());
    }

    @Test
    void takeDamageFire() {
        plantFamily.takeDamage(new Damage(DamageType.FIRE, 5));
        assertEquals(0, plantFamily.getCurrentHealth());
    }

    @Test
    void takeDamageNormal() {
        plantFamily.takeDamage(new Damage(DamageType.NORMAL, 5));
        assertEquals(5, plantFamily.getCurrentHealth());
    }

    @Test
    void specialAttackCharged() {
        assertEquals(10, plantFamily.specialAttack().getAmount());
    }

    @Test
    void specialAttackNotCharged() {
        plantFamily.setCharges(0);
        assertEquals(0, plantFamily.specialAttack().getAmount());
    }

    @Test
    void specialAttackType() {
        assertEquals(DamageType.PLANT, plantFamily.specialAttack().getType());
    }

    @Test
    void basicAttackType() {
        assertEquals(DamageType.NORMAL, plantFamily.basicAttack().getType());
    }

    @Test
    void restCharge() {
        plantFamily.setCharges(0);
        plantFamily.rest();
        assertEquals(1, plantFamily.getCharges());
    }
}