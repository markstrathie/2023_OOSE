package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class SnapExist{
  final String file_name = "src/main/java//Snap.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void isSnapExist(){
    assertTrue(javaFile.hasMethodByName("isSnap"));
  }

}