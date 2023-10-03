package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class PlantFamilyTestExist{
  final String file_name = "src/test/java//PlantFamilyTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void testLevelUpLevelExist(){
    assertTrue(javaFile.hasMethodByName("testLevelUpLevel"));
  }

  @Test
  void testLevelUpMaxChargesExist(){
    assertTrue(javaFile.hasMethodByName("testLevelUpMaxCharges"));
  }

  @Test
  void testSpecialAttackChargedExist(){
    assertTrue(javaFile.hasMethodByName("testSpecialAttackCharged"));
  }

  @Test
  void testSpecialAttackNotChargedExist(){
    assertTrue(javaFile.hasMethodByName("testSpecialAttackNotCharged"));
  }

  @Test
  void testTakeDamageFireExist(){
    assertTrue(javaFile.hasMethodByName("testTakeDamageFire"));
  }

  @Test
  void testTakeDamagePlantExist(){
    assertTrue(javaFile.hasMethodByName("testTakeDamagePlant"));
  }

  @Test
  void testBasicAttackTypeExist(){
    assertTrue(javaFile.hasMethodByName("testBasicAttackType"));
  }

  @Test
  void testRestChargeExist(){
    assertTrue(javaFile.hasMethodByName("testRestCharge"));
  }

}