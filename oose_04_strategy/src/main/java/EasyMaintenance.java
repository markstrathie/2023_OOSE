public class EasyMaintenance implements MaintenanceBehaviour{

	public static double EASY_MAINTENANCE_MUTIPLIER=0.005;
	
	public void maintainVehicle(Vehicle vehicle) 
	{	
		vehicle.setMaintenaceBill(vehicle.getDistanceSinceLastService()*EASY_MAINTENANCE_MUTIPLIER);
	}

}
