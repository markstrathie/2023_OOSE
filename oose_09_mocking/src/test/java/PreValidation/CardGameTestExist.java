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
  void cardGameOverrideExist(){
    assertTrue(javaFile.hasMethodByName("cardGameOverride"));
  }

  @Test
  void dealCardsExist(){
    assertTrue(javaFile.hasMethodByName("dealCards"));
  }

  @Test
  void getNumberOfPlayersExist(){
    assertTrue(javaFile.hasMethodByName("getNumberOfPlayers"));
  }

  @Test
  void getIntegerExist(){
    assertTrue(javaFile.hasMethodByName("getInteger"));
  }

  @Test
  void getIntegerFirstStringExist(){
    assertTrue(javaFile.hasMethodByName("getIntegerFirstString"));
  }

  @Test
  void getStringExist(){
    assertTrue(javaFile.hasMethodByName("getString"));
  }

  @Test
  void getComputerPlayersNamesExist(){
    assertTrue(javaFile.hasMethodByName("getComputerPlayersNames"));
  }

  @Test
  void createComputerPlayersExist(){
    assertTrue(javaFile.hasMethodByName("createComputerPlayers"));
  }

  @Test
  void createComputerPlayersSizeExist(){
    assertTrue(javaFile.hasMethodByName("createComputerPlayersSize"));
  }

  @Test
  void createHumanPlayerExist(){
    assertTrue(javaFile.hasMethodByName("createHumanPlayer"));
  }

  @Test
  void initiatePlayersExist(){
    assertTrue(javaFile.hasMethodByName("initiatePlayers"));
  }

  @Test
  void initiateExist(){
    assertTrue(javaFile.hasMethodByName("initiate"));
  }

  @Test
  void playExist(){
    assertTrue(javaFile.hasMethodByName("play"));
  }

}