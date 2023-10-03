public class HomeMaintenance implements MaintenanceBehaviour {
    public void maintainVehicle(Vehicle vehicle) {
        vehicle.setMaintenaceBill(0);
    }
}
