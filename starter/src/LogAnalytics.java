
public class LogAnalytics
{
	private static LogAnalytics uniqueInstance;
	private LogAnalytics()
	{
		System.out.println("Making a connection to the external database");
	}

	public static synchronized LogAnalytics getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new LogAnalytics();
		}
		return uniqueInstance;
	}
	
	public void logMove(Coordinates newCoordinates)
	{
		System.out.println("Logging:" +newCoordinates.toString());
	}
}
