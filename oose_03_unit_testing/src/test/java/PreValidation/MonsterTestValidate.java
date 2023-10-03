package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class MonsterTestValidate{
  final String file_name = "src/test/java//MonsterTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void testIsConsciousContainsAll(){
    String[] patterns = {"isConscious","assertTrue"};
    assertTrue(javaFile.getMethodByName("testIsConscious").containsAll(patterns));
  }

  @Test
  void testGetNameContainsAll(){
    String[] patterns = {"getName","assertEquals"};
    assertTrue(javaFile.getMethodByName("testGetName").containsAll(patterns));
  }

  @Test
  void testGetMonsterBreedContainsAll(){
    String[] patterns = {"Monster","assertEquals"};
    assertTrue(javaFile.getMethodByName("testGetMonsterBreed").containsAll(patterns));
  }

  @Test
  void testGetCurrentHealthContainsAll(){
    String[] patterns = {"getCurrentHealth","assertEquals"};
    assertTrue(javaFile.getMethodByName("testGetCurrentHealth").containsAll(patterns));
  }

  @Test
  void testGetMaxHealthContainsAll(){
    String[] patterns = {"getMaxHealth","assertEquals"};
    assertTrue(javaFile.getMethodByName("testGetMaxHealth").containsAll(patterns));
  }

  @Test
  void testSetNameContainsAll(){
    String[] patterns = {"setName","assertEquals"};
    assertTrue(javaFile.getMethodByName("testSetName").containsAll(patterns));
  }

}