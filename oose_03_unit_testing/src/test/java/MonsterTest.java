import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    Monster monster = new Monster("Sullivan", 1, 10 );

    @Test
    void testLevelUpHealth() {
        monster.levelUp();
        assertEquals(30, monster.getMaxHealth());
    }

    @Test
    void testLevelUpLevel() {
        monster.levelUp();
        assertEquals(2, monster.getMonsterLevel());
    }

    @Test
    void testRest() {
        monster.takeDamage(new Damage(DamageType.NORMAL, 5));
        monster.rest();
        assertEquals(10, monster.getCurrentHealth());
    }

    @Test
    void testBasicAttack() {
        assertNull(monster.basicAttack());
    }

    @Test
    void testSpecialAttack() {
        assertNull(monster.specialAttack());
    }

    @Test
    void testTakeDamage() {
        monster.takeDamage(new Damage(DamageType.NORMAL, 5));
        assertEquals(5, monster.getCurrentHealth());
    }

    @Test
    void testIsConscious() {
        assertTrue(monster.isConscious());
    }

    @Test
    void testIsConsciousNoLonger() {
        monster.takeDamage(new Damage(DamageType.NORMAL, 10));
        assertFalse(monster.isConscious());
    }

    @Test
    void testGetName() {
        assertEquals("Sullivan", monster.getName());
    }

    @Test
    void testGetMonsterBreed() {
        assertEquals("UNKNOWN", monster.getMonsterBreed());
    }

    @Test
    void testGetMonsterLevel() {
        assertEquals(1, monster.getMonsterLevel());
    }

    @Test
    void testGetCurrentHealth() {
        assertEquals(10, monster.getCurrentHealth());
    }

    @Test
    void testGetMaxHealth() {
        assertEquals(10, monster.getMaxHealth());
    }

    @Test
    void testSetName() {
        monster.setName("Frank");
        assertEquals("Frank", monster.getName());
    }
}