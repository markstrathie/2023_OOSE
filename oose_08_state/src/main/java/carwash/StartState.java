package carwash;
public class StartState implements WashState {

    private CarWash carWash;

    public StartState(CarWash trafficLight){
        this.carWash = trafficLight;
    }

    public void setState(){
        this.carWash.setWashState(new TakeMoneyState(this.carWash));
    }

    public String getState(){
        return CarWashStage.START.getStage();
    }
}
