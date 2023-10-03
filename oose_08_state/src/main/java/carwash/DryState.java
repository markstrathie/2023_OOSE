package carwash;

public class DryState implements WashState{
    private CarWash carWash;

    public DryState(CarWash trafficLight){
        this.carWash = trafficLight;
    }

    private void dryCar(){
        System.out.println("Dry Car");
    }

    public void setState(){
        dryCar();
        if (this.carWash.getLevelOfCarWash() == LevelOfCarWash.GOLD){
            this.carWash.setWashState(new WashFinishState(this.carWash));
        } else {
                this.carWash.setWashState(new PolishState(this.carWash));
            }
    }

    public String getState(){
        return CarWashStage.DRY.getStage();
    }
}
