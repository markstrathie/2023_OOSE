package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class CarValidate{
  final String file_name = "src/main/java//Car.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void CarContainsAll(){
    String[] patterns = {"public","TravelBehaviour","MaintenanceBehaviour"};
    assertTrue(javaFile.getMethodByName("Car").containsAll(patterns));
  }

}