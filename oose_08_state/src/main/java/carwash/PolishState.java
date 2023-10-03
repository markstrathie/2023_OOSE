package carwash;

public class PolishState implements WashState{
    private CarWash carWash;

    public PolishState(CarWash trafficLight){
        this.carWash = trafficLight;
    }

    private void polishCar(){
        System.out.println("Polish Car");
    }

    public void setState(){
        polishCar();
        this.carWash.setWashState(new WashFinishState(this.carWash));
    }

    public String getState(){
        return CarWashStage.POLISH.getStage();
    }
}
