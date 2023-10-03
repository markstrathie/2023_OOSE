package carwash;
public class WashFinishState implements WashState {

    private CarWash carWash;

    public WashFinishState(CarWash trafficLight){
        this.carWash = trafficLight;
    }

    private void finish(){
        System.out.println("Finished");
    }

    public void setState(){
        finish();
    }

    public String getState(){
        return CarWashStage.FINISH.getStage();
    }
}
