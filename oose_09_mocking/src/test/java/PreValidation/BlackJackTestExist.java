package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class BlackJackTestExist{
  final String file_name = "src/test/java//BlackJackTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void generateHelpExist(){
    assertTrue(javaFile.hasMethodByName("generateHelp"));
  }

  @Test
  void determineWinnerExist(){
    assertTrue(javaFile.hasMethodByName("determineWinner"));
  }

  @Test
  void getScoreFiveExist(){
    assertTrue(javaFile.hasMethodByName("getScoreFive"));
  }

  @Test
  void getScoreAceHighExist(){
    assertTrue(javaFile.hasMethodByName("getScoreAceHigh"));
  }

  @Test
  void getScoreAceLowExist(){
    assertTrue(javaFile.hasMethodByName("getScoreAceLow"));
  }

}