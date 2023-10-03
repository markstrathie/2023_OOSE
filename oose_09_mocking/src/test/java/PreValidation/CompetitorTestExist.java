package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class CompetitorTestExist{
  final String file_name = "src/test/java//CompetitorTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void hasWonExist(){
    assertTrue(javaFile.hasMethodByName("hasWon"));
  }

  @Test
  void hasWonNotExist(){
    assertTrue(javaFile.hasMethodByName("hasWonNot"));
  }

  @Test
  void hasHandExist(){
    assertTrue(javaFile.hasMethodByName("hasHand"));
  }

  @Test
  void hasHandNotExist(){
    assertTrue(javaFile.hasMethodByName("hasHandNot"));
  }

  @Test
  void getPlayerTypeExist(){
    assertTrue(javaFile.hasMethodByName("getPlayerType"));
  }

  @Test
  void getNameExist(){
    assertTrue(javaFile.hasMethodByName("getName"));
  }

  @Test
  void getHandExist(){
    assertTrue(javaFile.hasMethodByName("getHand"));
  }

}