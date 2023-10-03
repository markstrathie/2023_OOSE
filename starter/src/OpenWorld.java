import java.util.ArrayList;
import java.util.Random;

import javax.management.loading.PrivateClassLoader;

public class OpenWorld {
	
	private int northSouthBoundary, eastWestBoundary; 
	private PlayerLocation playerLocation;
	private ArrayList<Encounter> encounters = new ArrayList<Encounter>();

	private Boolean gameOver;
	
	public OpenWorld()
	{
	
	}
	
	private void initialise(int northSouthBoundary, int eastWestBoundary)
	{
		this.gameOver = false;
		this.northSouthBoundary = northSouthBoundary;
		this.eastWestBoundary = eastWestBoundary;
		playerLocation = new PlayerLocation(northSouthBoundary, eastWestBoundary);
		playerLocation.changeCoordinates(new Coordinates(0,0));
		SimpleEncounterFactory simpleEncounterFactory = new SimpleEncounterFactory();
		EncounterCreator encounterCreator = new EncounterCreator(simpleEncounterFactory);

		for (int xAxis = 0; xAxis<eastWestBoundary; xAxis++) {
			for (int yAxis = 0; yAxis<northSouthBoundary; yAxis++) {
				Encounter encounter;
				if (xAxis == 0 && yAxis == 0) {
					encounter = encounterCreator.createEncounter(Encounters.values()[new Random().nextInt(Encounters.values().length - 1)]);
				} else {
					encounter = encounterCreator.createEncounter(Encounters.values()[new Random().nextInt(Encounters.values().length)]);
				}
				encounter.setEncounterCoordinates(new Coordinates(yAxis, xAxis));
				encounters.add(encounter);
			}
		}

		boolean containsFinish = false;
		for (Encounter encounter : encounters) {
			if (encounter.name.equals("Finish point")) {
				containsFinish = true;
				break;
			}
		}

		if (!containsFinish) {
			int randomEncounter = new Random().nextInt(Encounters.values().length - 1) + 1;
			Coordinates changeEncounterCoordinates = encounters.get(randomEncounter).encounterCoordinates;
			Encounter encounter = encounterCreator.createEncounter(Encounters.FINISH_POINT);
			encounter.setEncounterCoordinates(changeEncounterCoordinates);
			encounters.set(randomEncounter, encounter);
		}

		for (Encounter encounter : encounters) {
			encounter.printEncounterDetails();
		}
		System.out.println("---------------------------");
	}
	
	private void playerMove(int northSouthChange, int eastWestChange)
	{
		if (gameOver) {
			System.out.println("The game is over");
		} else {
			LogAnalytics.getInstance().logMove(new Coordinates(northSouthChange, eastWestChange));
			playerLocation.changeCoordinates(new Coordinates(playerLocation.getPlayerCoordinates().getNorthSouth()+northSouthChange, playerLocation.getPlayerCoordinates().getEastWest()+eastWestChange));
			for (Encounter encounter : encounters) {
				if (encounter.encounterCoordinates.isHere(playerLocation.getPlayerCoordinates())) {
					encounter.printout();
				}
			}
		}
		System.out.println("---------------------------");
	}
	

	public static void main(String[]args)
	{
		OpenWorld world = new OpenWorld();
		world.initialise(2,2);
		world.playerMove(1,0);
		world.playerMove(0,1);
		
		
	}

}
