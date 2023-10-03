package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class SevensTestExist{
  final String file_name = "src/test/java/SevensTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void testCreateEmptyTableHandsSizeExist(){
    assertTrue(javaFile.hasMethodByName("testCreateEmptyTableHandsSize"));
  }

  @Test
  void testPlayToTablePlayASevenToEmptyExist(){
    assertTrue(javaFile.hasMethodByName("testPlayToTablePlayASevenToEmpty"));
  }

  @Test
  void testPlayToTablePlayASevenNotEmptyExist(){
    assertTrue(javaFile.hasMethodByName("testPlayToTablePlayASevenNotEmpty"));
  }

  @Test
  void testPlayToTablePlayASevenCheckCardExist(){
    assertTrue(javaFile.hasMethodByName("testPlayToTablePlayASevenCheckCard"));
  }

  @Test
  void testPlayToTablePlayASixWithASevenExist(){
    assertTrue(javaFile.hasMethodByName("testPlayToTablePlayASixWithASeven"));
  }

  @Test
  void testPlayToTablePlayAFiveWithNoSixExist(){
    assertTrue(javaFile.hasMethodByName("testPlayToTablePlayAFiveWithNoSix"));
  }

  @Test
  void testPlayToTablePlayASixCheckCardExist(){
    assertTrue(javaFile.hasMethodByName("testPlayToTablePlayASixCheckCard"));
  }

  @Test
  void testPlayToTablePlayAnEightWithASevenExist(){
    assertTrue(javaFile.hasMethodByName("testPlayToTablePlayAnEightWithASeven"));
  }

  @Test
  void testPlayToTablePlayANineWithNoEightExist(){
    assertTrue(javaFile.hasMethodByName("testPlayToTablePlayANineWithNoEight"));
  }

  @Test
  void testPlayToTablePlayAnEightCheckCardExist(){
    assertTrue(javaFile.hasMethodByName("testPlayToTablePlayAnEightCheckCard"));
  }

  @Test
  void testPlayerHasWonTrueExist(){
    assertTrue(javaFile.hasMethodByName("testPlayerHasWonTrue"));
  }

  @Test
  void testPlayerHasWonFalseExist(){
    assertTrue(javaFile.hasMethodByName("testPlayerHasWonFalse"));
  }

  @Test
  void testDetermineWinnerExist(){
    assertTrue(javaFile.hasMethodByName("testDetermineWinner"));
  }

}