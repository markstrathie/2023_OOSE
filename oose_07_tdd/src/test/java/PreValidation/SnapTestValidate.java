package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class SnapTestValidate{
  final String file_name = "src/test/java//SnapTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

}