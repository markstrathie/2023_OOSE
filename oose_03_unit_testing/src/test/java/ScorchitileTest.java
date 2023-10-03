import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScorchitileTest {

    Scorchitile scorchitile = new Scorchitile("flamey", 1, 10, 10);

    @Test
    void getName() {
        assertEquals("flamey", scorchitile.getName());
    }

    @Test
    void getMonsterBreed() {
        assertEquals("Scorchitile", scorchitile.getMonsterBreed());
    }

    @Test
    void getMonsterLevel() {
        assertEquals(1, scorchitile.getMonsterLevel());
    }

    @Test
    void getCurrentHealth() {
        assertEquals(10, scorchitile.getCurrentHealth());
    }

    @Test
    void getMaxHealth() {
        assertEquals(10, scorchitile.getMaxHealth());
    }

    @Test
    void basicAttack() {
        assertEquals(20, scorchitile.basicAttack().getAmount());
    }
}