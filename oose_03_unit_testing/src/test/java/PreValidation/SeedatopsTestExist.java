package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class SeedatopsTestExist{
  final String file_name = "src/test/java//SeedatopsTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void testBasicAttackExist(){
    assertTrue(javaFile.hasMethodByName("testBasicAttack"));
  }

  @Test
  void testTakeDamageAndBasicAttackExist(){
    assertTrue(javaFile.hasMethodByName("testTakeDamageAndBasicAttack"));
  }

}