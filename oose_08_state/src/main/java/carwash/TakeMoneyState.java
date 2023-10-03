package carwash;
public class TakeMoneyState implements WashState {

    private CarWash carWash;

    public TakeMoneyState(CarWash carWash){
        this.carWash = carWash;
    }

    private void takeMoney(){
        System.out.println("Take money");
    }

    public void setState(){
        takeMoney();
        this.carWash.setWashState(new WashCarBodyState(this.carWash));
    }

    public String getState(){

        return CarWashStage.TAKEMONEY.getStage();
    }
}
