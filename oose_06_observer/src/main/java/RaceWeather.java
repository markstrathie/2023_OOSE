import java.util.ArrayList;
import java.util.List;

public class RaceWeather implements Subject{
	private WeatherType weatherType;
	private List<Observer> observers;

	public RaceWeather(WeatherType weatherType) {
		this.weatherType = weatherType;
	}

	public void registerObserver(Observer observer){
		observers.add(observer);
	}

	public void removeObserver(Observer observer){
		observers.remove(observer);
	}

	public void notifyObserver(){
		for (Observer observer : observers){
			observer.update(weatherType);
		}

	}
	
	// For observers to pull the weather when notified or at creation
	public WeatherType getWeatherType() {
		return weatherType;
	}

	// Notify that there are changes to pull



	public void changeWeather() {
		weatherType = weatherType.next();
	}
}
