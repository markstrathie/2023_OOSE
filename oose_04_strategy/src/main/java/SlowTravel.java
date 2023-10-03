public class SlowTravel implements TravelBehaviour{

	public double travel(double hoursTravelled, Vehicle vehicle) 
	{	
		return 0.5*vehicle.maxSpeed*hoursTravelled;
	}
}
