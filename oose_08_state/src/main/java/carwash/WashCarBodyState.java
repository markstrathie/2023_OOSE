package carwash;
public class WashCarBodyState implements WashState {

    private CarWash carWash;

    public WashCarBodyState(CarWash trafficLight){
        this.carWash = trafficLight;
    }

    private void washCarBody(){
        System.out.println("Wash car body");
    }

    public void setState(){
        washCarBody();
        this.carWash.setWashState(new WashWheelState(this.carWash));
    }

    public String getState(){
        return CarWashStage.CARBODY.getStage();
    }
}
