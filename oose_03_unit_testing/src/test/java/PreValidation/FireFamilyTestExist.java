package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class FireFamilyTestExist{
  final String file_name = "src/test/java//FireFamilyTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void testLevelUpHealthExist(){
    assertTrue(javaFile.hasMethodByName("testLevelUpHealth"));
  }

  @Test
  void testLevelUpLevelExist(){
    assertTrue(javaFile.hasMethodByName("testLevelUpLevel"));
  }

  @Test
  void testLevelUpFireManaExist(){
    assertTrue(javaFile.hasMethodByName("testLevelUpFireMana"));
  }

  @Test
  void testTakeDamageExist(){
    assertTrue(javaFile.hasMethodByName("testTakeDamage"));
  }

  @Test
  void testSpecialAttackTypeExist(){
    assertTrue(javaFile.hasMethodByName("testSpecialAttackType"));
  }

  @Test
  void testSpecialAttackLessFireManaExist(){
    assertTrue(javaFile.hasMethodByName("testSpecialAttackLessFireMana"));
  }

  @Test
  void testSpecialAttackGreaterFireManaExist(){
    assertTrue(javaFile.hasMethodByName("testSpecialAttackGreaterFireMana"));
  }

  @Test
  void testBasicAttackExist(){
    assertTrue(javaFile.hasMethodByName("testBasicAttack"));
  }

  @Test
  void testRestExist(){
    assertTrue(javaFile.hasMethodByName("testRest"));
  }

}