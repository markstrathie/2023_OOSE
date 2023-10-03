import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

class CardGameTest {
    CardGame cardGame = new CardGame();

    @Test
    void getDeck() {
        assertEquals(52, cardGame.getDeck().size());
    }

    @Test
    void cardGameOverride(){
        CardGame overrideCardGame = new CardGame("H3,H4,H5,D6");
        assertEquals(4, overrideCardGame.getDeck().size());
    }

    @Test
    void dealCards() {
        CardGame cardGame = new CardGame("D3,D2,S5,S6");
        Hand hand = new Hand();
        hand = cardGame.dealHand(hand, 3);
        assertEquals("S6, S5, D2", hand.toString());
    }

    @Test
    void outputOne(){
        cardGame.print("Test One");
        assertEquals("Test One", cardGame.storedOutput.get(0));
    }

    @Test
    void outputTwo(){
        cardGame.print("Test One");
        cardGame.print("Test Two");
        assertEquals("Test Two", cardGame.storedOutput.get(1));
    }

    @Test
    void outputTwoCount(){
        cardGame.print("Test One");
        cardGame.print("Test Two");
        assertEquals(2, cardGame.storedOutput.size());
    }


    @Test
    void getNumberOfPlayers(){
        fail("Not yet implemented"); //Remove
    }

    @Test
    void getInteger(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("3");
        cardGame.userInput = mockScanner;
        assertEquals(3, cardGame.getInteger());

    }

    @Test
    void getIntegerFirstString(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("one");
        when(mockScanner.nextLine()).thenReturn("25");
        cardGame.userInput = mockScanner;
        assertEquals(25, cardGame.getInteger());
    }

    @Test
    void getString(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("yes");
        cardGame.userInput = mockScanner;
        assertEquals("yes", cardGame.getString());
    }

    @Test
    void getComputerPlayersNames(){
        List<String> testNames = new ArrayList<>();
        testNames.add("Shalaj");
        testNames.add("Mark");
        testNames.add("Connor");
        LoadConfig mockLoadConfig = mock(LoadConfig.class);
        when(mockLoadConfig.getConfig()).thenReturn(testNames);
        cardGame.loadConfig = mockLoadConfig;
        assertEquals(testNames, cardGame.getComputerPlayersNames());

    }

    @Test
    void createComputerPlayers(){
        List<String> testNames = new ArrayList<>();
        testNames.add("Shalaj");
        testNames.add("Mark");
        testNames.add("Connor");

        CardGame spyCardGame = spy(cardGame);
        spyCardGame.createComputerCompetitors(testNames);

        assertEquals("Connor", spyCardGame.competitors.get(2).getName());
    }

    @Test
    void createComputerPlayersSize(){
        List<String> testNames = new ArrayList<>();
        testNames.add("Shalaj");
        testNames.add("Mark");
        testNames.add("Connor");

        CardGame spyCardGame = spy(cardGame);
        spyCardGame.createComputerCompetitors(testNames);

        assertEquals(3, spyCardGame.competitors.size());
    }

    @Test
    void createHumanPlayer(){
        CardGame spyCardGame = spy(cardGame);

        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Mark");
        spyCardGame.userInput = mockScanner;

        spyCardGame.createHumanPlayer();

        assertEquals("Mark", spyCardGame.competitors.get(0).getName());
    }

    @Test
    void initiatePlayers(){
        CardGame spyCardGame = spy(cardGame);

        List<String> testNames = new ArrayList<>();
        testNames.add("Shalaj");
        testNames.add("Mark");
        testNames.add("Connor");

        LoadConfig mockLoadConfig = mock(LoadConfig.class);
        when(mockLoadConfig.getConfig()).thenReturn(testNames);
        spyCardGame.loadConfig = mockLoadConfig;

        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Mark");
        spyCardGame.userInput = mockScanner;

        spyCardGame.initiatePlayers();
        assertEquals(4, spyCardGame.competitors.size());
    }

    @Test
    void initiate(){

        CardGame spyCardGame = spy(cardGame);

        List<String> testNames = new ArrayList<>();
        testNames.add("Shalaj");
        testNames.add("Mark");
        testNames.add("Connor");

        LoadConfig mockLoadConfig = mock(LoadConfig.class);
        when(mockLoadConfig.getConfig()).thenReturn(testNames);
        spyCardGame.loadConfig = mockLoadConfig;

        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Mark");
        spyCardGame.userInput = mockScanner;

        spyCardGame.initiate();
        assertTrue(spyCardGame.competitors.get(0).hasHand());
    }

    @Test
    void play(){

        CardGame spyCardGame = spy(cardGame);

        List<String> testNames = new ArrayList<>();
        testNames.add("Shalaj");
        testNames.add("Mark");
        testNames.add("Connor");

        LoadConfig mockLoadConfig = mock(LoadConfig.class);
        when(mockLoadConfig.getConfig()).thenReturn(testNames);
        spyCardGame.loadConfig = mockLoadConfig;

        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Mark");
        spyCardGame.userInput = mockScanner;

        when(spyCardGame.initiate()).thenCallRealMethod(spyCardGame.competitors.get(0).setWinner(true));
        spyCardGame.play();
        assertTrue(spyCardGame.finishGame);
    }

}