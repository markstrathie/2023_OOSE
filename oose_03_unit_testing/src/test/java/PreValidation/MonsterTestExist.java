package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class MonsterTestExist{
  final String file_name = "src/test/java//MonsterTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void testIsConsciousExist(){
    assertTrue(javaFile.hasMethodByName("testIsConscious"));
  }

  @Test
  void testGetNameExist(){
    assertTrue(javaFile.hasMethodByName("testGetName"));
  }

  @Test
  void testGetMonsterBreedExist(){
    assertTrue(javaFile.hasMethodByName("testGetMonsterBreed"));
  }

  @Test
  void testGetCurrentHealthExist(){
    assertTrue(javaFile.hasMethodByName("testGetCurrentHealth"));
  }

  @Test
  void testGetMaxHealthExist(){
    assertTrue(javaFile.hasMethodByName("testGetMaxHealth"));
  }

  @Test
  void testSetNameExist(){
    assertTrue(javaFile.hasMethodByName("testSetName"));
  }

}