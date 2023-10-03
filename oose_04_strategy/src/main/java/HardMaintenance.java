public class HardMaintenance implements MaintenanceBehaviour {

    public static double HARD_MAINTENANCE_MUTIPLIER = 0.1;

    public void maintainVehicle(Vehicle vehicle) {
        vehicle.setMaintenaceBill(vehicle.getDistanceSinceLastService()*HARD_MAINTENANCE_MUTIPLIER);
    }
}


