import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeedatopsTest {

    Seedatops seedatops = new Seedatops("leafy", 1, 10, 1);

    @Test
    void getName() {
        assertEquals("leafy", seedatops.getName());
    }

    @Test
    void getMonsterBreed() {
        assertEquals("Seedatops", seedatops.getMonsterBreed());
    }

    @Test
    void getMonsterLevel() {
        assertEquals(1, seedatops.getMonsterLevel());
    }

    @Test
    void getCurrentHealth() {
        assertEquals(10, seedatops.getCurrentHealth());
    }

    @Test
    void getMaxHealth() {
        assertEquals(10, seedatops.getMaxHealth());
    }

    @Test
    void takeDamage() {
        seedatops.takeDamage(new Damage(DamageType.NORMAL, 5));
        assertEquals(5, seedatops.getCurrentHealth());
    }

    @Test
    void takeDamageAndBasicAttack() {
        seedatops.takeDamage(new Damage(DamageType.NORMAL, 5));
        seedatops.basicAttack();
        assertEquals(10, seedatops.getCurrentHealth());
    }
}