package carwash;
public class WashWheelState implements WashState {

    private CarWash carWash;

    public WashWheelState(CarWash carWash){
        this.carWash = carWash;
    }

    private void washWheel(){
        System.out.println("Wash wheels");
    }

    public void setState(){
        washWheel();
        if (this.carWash.getLevelOfCarWash() == LevelOfCarWash.SILVER){
            this.carWash.setWashState(new WashFinishState(this.carWash));
        } else {
            this.carWash.setWashState(new DryState(this.carWash));
        }

    }

    public String getState(){
        return CarWashStage.WHEEL.getStage();
    }
}
