package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class ScorchitileTestExist{
  final String file_name = "src/test/java//ScorchitileTest.java";
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

}