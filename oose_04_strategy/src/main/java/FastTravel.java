public class FastTravel implements TravelBehaviour{

    public double travel(double hoursTravelled, Vehicle vehicle)
    {
        return vehicle.maxSpeed*hoursTravelled;
    }

}
