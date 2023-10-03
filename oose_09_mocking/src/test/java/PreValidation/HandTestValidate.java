package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class HandTestValidate{
  final String file_name = "src/test/java//HandTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

}