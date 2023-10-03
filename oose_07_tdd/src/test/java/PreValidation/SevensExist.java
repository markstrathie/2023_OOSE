package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class SevensExist{
  final String file_name = "src/main/java//Sevens.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void createEmptyTableHandsExist(){
    assertTrue(javaFile.hasMethodByName("createEmptyTableHands"));
  }

  @Test
  void playToTableExist(){
    assertTrue(javaFile.hasMethodByName("playToTable"));
  }

  @Test
  void determineWinnerExist(){
    assertTrue(javaFile.hasMethodByName("determineWinner"));
  }

}