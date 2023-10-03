package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class FireFamilyTestValidate{
  final String file_name = "src/test/java//FireFamilyTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void testLevelUpHealthContainsAll(){
    String[] patterns = {"levelUp","assertEquals"};
    assertTrue(javaFile.getMethodByName("testLevelUpHealth").containsAll(patterns));
  }

  @Test
  void testLevelUpLevelContainsAll(){
    String[] patterns = {"levelUp","assertEquals"};
    assertTrue(javaFile.getMethodByName("testLevelUpLevel").containsAll(patterns));
  }

  @Test
  void testLevelUpFireManaContainsAll(){
    String[] patterns = {"levelUp","assertEquals"};
    assertTrue(javaFile.getMethodByName("testLevelUpFireMana").containsAll(patterns));
  }

  @Test
  void testTakeDamageContainsAll(){
    String[] patterns = {"takeDamage","assertEquals"};
    assertTrue(javaFile.getMethodByName("testTakeDamage").containsAll(patterns));
  }

  @Test
  void testSpecialAttackTypeContainsAll(){
    String[] patterns = {"specialAttack","assertEquals"};
    assertTrue(javaFile.getMethodByName("testSpecialAttackType").containsAll(patterns));
  }

  @Test
  void testSpecialAttackLessFireManaContainsAll(){
    String[] patterns = {"specialAttack","assertEquals"};
    assertTrue(javaFile.getMethodByName("testSpecialAttackLessFireMana").containsAll(patterns));
  }

  @Test
  void testSpecialAttackGreaterFireManaContainsAll(){
    String[] patterns = {"specialAttack","assertEquals"};
    assertTrue(javaFile.getMethodByName("testSpecialAttackGreaterFireMana").containsAll(patterns));
  }

  @Test
  void testBasicAttackContainsAll(){
    String[] patterns = {"basicAttack","assertEquals"};
    assertTrue(javaFile.getMethodByName("testBasicAttack").containsAll(patterns));
  }

  @Test
  void testRestContainsAll(){
    String[] patterns = {"rest","assertEquals"};
    assertTrue(javaFile.getMethodByName("testRest").containsAll(patterns));
  }

}