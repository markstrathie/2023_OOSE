

public abstract class Encounter{

	Coordinates playerCoordinates;
	Coordinates encounterCoordinates;
	String name;
	String nearbyAlert;
	String printout;



	public void printEncounterDetails() {
		System.out.println(name + " "+ encounterCoordinates.toString());
	}

	public void setEncounterCoordinates(Coordinates encounterCoordinates) {
		this.encounterCoordinates = encounterCoordinates;
	}

	public void printout() {
		System.out.println(printout);
	}
	

}
