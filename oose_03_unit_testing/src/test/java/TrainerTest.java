import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    Scorchitile scorchitile = new Scorchitile("flamey", 2, 20, 20);
    Scorchitile scorchitileBig = new Scorchitile("flamasaur", 10, 100, 100);
    Seedatops seedatops = new Seedatops("baby seed", 1, 10, 1);
    Trainer trainer = new Trainer(scorchitile);

    @Test
    void constructorTrainer() {
        assertEquals("flamey", trainer.getMonsters()[0].getName());
    }

    @Test
    void addMonster() {
        trainer.addMonster(scorchitile);
        trainer.addMonster(scorchitile);
        trainer.addMonster(scorchitile);
        trainer.addMonster(scorchitile);
        trainer.addMonster(scorchitile);
        trainer.addMonster(scorchitile);
        assertEquals(6, trainer.getNumberOfMonsters());
    }

    @Test
    void addMonsterOnlyMax() {
        trainer.addMonster(scorchitile);
        trainer.addMonster(scorchitile);
        trainer.addMonster(scorchitile);
        trainer.addMonster(scorchitile);
        trainer.addMonster(scorchitile);
        trainer.addMonster(scorchitile);
        trainer.addMonster(scorchitile);
        assertEquals(6, trainer.getNumberOfMonsters());
    }

    @Test
    void fightLossToHigherLevel() {
        trainer.fight(0, scorchitileBig);
        assertEquals(0, trainer.getMonsters()[0].getCurrentHealth());
    }

    @Test
    void restTeam() {
        trainer.fight(0, scorchitileBig);
        trainer.restTeam();
        assertEquals(20, trainer.getMonsters()[0].getCurrentHealth());
    }

    @Test
    void fightLevelUp() {
        trainer.fight(0, seedatops);
        assertEquals(3, trainer.getMonsters()[0].getMonsterLevel());
    }

    @Test
    void fightSeedatopsLevel1LossToScorchitileLevel2() {
        trainer.addMonster(seedatops);
        trainer.fight(1, scorchitile);
        assertFalse(trainer.getMonsters()[1].isConscious());
    }

}