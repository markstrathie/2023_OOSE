import java.util.ArrayList;
import java.util.List;

public class Race {
	private RaceWeather raceWeather;
	private int raceTrackDistance;
	private List<RaceCar> racers = new ArrayList<RaceCar>();
	private final int numberOfStepsToChange = 2;

	public Race(WeatherType weather, int raceTrackDistance) {
		this.raceWeather = new RaceWeather(weather);
		this.raceTrackDistance = raceTrackDistance;
	}

	private String getOutcome() {
		RaceCar winner = null, runnerUp = null;
		int travelDistance, winnerDistance = -1, runnerUpDistance = -1;
		
		for (RaceCar car : racers) {
			travelDistance = car.getMetersTravelled();
			if (travelDistance > raceTrackDistance) {
				if (travelDistance > winnerDistance) {
					// Move current winner down to runner-up
					runnerUpDistance = winnerDistance;
					runnerUp = winner;
					// Update winner
					winnerDistance = travelDistance;
					winner = car;
				} else if (travelDistance > runnerUpDistance) {
					// Update runner-up
					runnerUpDistance = travelDistance;
					runnerUp = car;
				}
			}
		}
		
		if (winner == null)
			// If no racers, or method called before any racer finishes
			return "NO WINNER";
		else if (winnerDistance == runnerUpDistance)
			return "TIE";
		else
			return "WINNER:" + winner.getName() + ", " + winner.getManufacturer();

	}

	public void progressWeather() {
		raceWeather.changeWeather();
	}

	public void changeCarBehaviour(int position, Behaviour newDrivingBehaviour) {
		if (position >= 0 && position < racers.size())
			racers.get(position).changeDrivingBehaviour(newDrivingBehaviour);
	}

	public RaceWeather getRaceWeather(){
		return raceWeather;
	}

	public WeatherType getWeatherType(){
		return raceWeather.getWeatherType();
	}

	public void raceStep() {
		for (RaceCar car : racers) {
			car.driveCar();
			System.out.println(car.toSting());
		}
	}

	public boolean isFinished() {
		Boolean hasFinished = false;
		int counter = 0;
		while (counter < racers.size() && ! hasFinished) {
			if (racers.get(counter).getMetersTravelled() >= raceTrackDistance) {
				hasFinished = true;
			}
			counter += 1;
		}
		return hasFinished;
	}

	public void raceCars() {
		int stepCount = 0;
		while (!isFinished()) {
			stepCount++;
			raceStep();
			if (stepCount % numberOfStepsToChange == 0) {
				progressWeather();
			}
		}
	}

	public int getRaceTrackDistance(){
		return raceTrackDistance;
	}


	public List<RaceCar> getRacers(){
		return this.racers;
	}

	public static void main(String[] args) {
		Race race = new Race(WeatherType.DRY, 100);
		race.raceCars();
		System.out.println(race.getOutcome());
	}
}
