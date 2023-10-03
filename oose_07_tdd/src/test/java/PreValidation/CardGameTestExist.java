package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class CardGameTestExist{
  final String file_name = "src/test/java//CardGameTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void getDeckExist(){
    assertTrue(javaFile.hasMethodByName("getDeck"));
  }

  @Test
  void dealCardsExist(){
    assertTrue(javaFile.hasMethodByName("dealCards"));
  }

}