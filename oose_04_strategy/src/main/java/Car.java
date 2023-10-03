public class Car extends Vehicle{
	
	public Car(TravelBehaviour travel, MaintenanceBehaviour maintain) 
	{
		super(travel, maintain);
	}
	
	public void takeDamage()
	{
		super.setMaintain(new HardMaintenance());
	}
}
