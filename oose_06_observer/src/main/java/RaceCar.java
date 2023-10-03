public class RaceCar implements Observer{
	private int metersTravelled = 0;
	private Manufacturer manufacturer;
	private String carName;
	private Behaviour drivingBehaviour;
	private Behaviour wheel;
	private WeatherType weatherType;

	public RaceCar(Manufacturer manufacturer, String carName, Behaviour drivingBehaviour, RaceWeather raceWeather){
		this.manufacturer = manufacturer;
		this.carName = carName;
		this.drivingBehaviour = drivingBehaviour;
		this.weatherType = raceWeather.getWeatherType();
		raceWeather.registerObserver(this);
	}
	
	public void update(WeatherType weatherType) {
		this.weatherType = weatherType;
	}

	public int driveCar() {
		int distance = drivingBehaviour.distanceTraveledInWeather(weatherType);
		metersTravelled += distance;
		return distance;
	}

	public void changeDrivingBehaviour(Behaviour newDrivingBehaviour) {
		this.drivingBehaviour = newDrivingBehaviour;
	}

	public void changeWheel(Behaviour wheel){
		this.wheel = wheel;
	}
	public String toSting() {
		return carName + " built by " + manufacturer + " has travelled " + metersTravelled + " meters";
	}
	
	public int getMetersTravelled() {
		return metersTravelled;
	}
	
	public String getName() {
		return carName;
	}
	
	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public Behaviour getDrivingBehaviour(){
		return drivingBehaviour;
	}

	public Behaviour getWheel(){
		return wheel;
	}

	public WeatherType getWeatherType(){
		return weatherType;
	}

	public setWheel(wheel){

	}


}
