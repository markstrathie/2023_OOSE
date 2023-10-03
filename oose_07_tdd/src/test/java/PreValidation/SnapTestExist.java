package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class SnapTestExist{
  final String file_name = "src/test/java//SnapTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void testIsSnapSameSuitCheckSuitExist(){
    assertTrue(javaFile.hasMethodByName("testIsSnapSameSuitCheckSuit"));
  }

  @Test
  void testIsSnapSameRankCheckSuitExist(){
    assertTrue(javaFile.hasMethodByName("testIsSnapSameRankCheckSuit"));
  }

  @Test
  void testIsSnapSameRankCheckRankExist(){
    assertTrue(javaFile.hasMethodByName("testIsSnapSameRankCheckRank"));
  }

  @Test
  void testIsSnapSameSuitCheckRankExist(){
    assertTrue(javaFile.hasMethodByName("testIsSnapSameSuitCheckRank"));
  }

}