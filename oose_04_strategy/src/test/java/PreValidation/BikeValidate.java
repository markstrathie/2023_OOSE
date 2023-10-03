package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class BikeValidate{
  final String file_name = "src/main/java//Bike.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void BikeContainsAll(){
    String[] patterns = {"public","TravelBehaviour","MaintenanceBehaviour","super"};
    assertTrue(javaFile.getMethodByName("Bike").containsAll(patterns));
  }

}