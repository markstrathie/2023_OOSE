package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class TrainerTestExist{
  final String file_name = "src/test/java//TrainerTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void testConstructorTrainerExist(){
    assertTrue(javaFile.hasMethodByName("testConstructorTrainer"));
  }

  @Test
  void testAddMonsterExist(){
    assertTrue(javaFile.hasMethodByName("testAddMonster"));
  }

  @Test
  void testAddMonsterOnlyMaxExist(){
    assertTrue(javaFile.hasMethodByName("testAddMonsterOnlyMax"));
  }

  @Test
  void testFightLossToHigherLevelExist(){
    assertTrue(javaFile.hasMethodByName("testFightLossToHigherLevel"));
  }

  @Test
  void testRestTeamExist(){
    assertTrue(javaFile.hasMethodByName("testRestTeam"));
  }

  @Test
  void testFightLevelUpExist(){
    assertTrue(javaFile.hasMethodByName("testFightLevelUp"));
  }

  @Test
  void testFightSeedatopLevel1LossToScorchitileLevel2Exist(){
    assertTrue(javaFile.hasMethodByName("testFightSeedatopLevel1LossToScorchitileLevel2"));
  }

}