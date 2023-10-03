public class Bike extends Vehicle{

	public Bike(TravelBehaviour travel, MaintenanceBehaviour maintain)
	{
		super(travel, maintain);
	}


	public void learnHomeMaintenance()
	{
		super.setMaintain(new HomeMaintenance());
	}

}
