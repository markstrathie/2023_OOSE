package carwash;

public class CarWash {

    public WashState washState;
    public LevelOfCarWash levelOfCarWash;

    public CarWash(){
    }

    public WashState getColourState(){
        return this.washState;
    }

    public LevelOfCarWash getLevelOfCarWash(){
        return levelOfCarWash;
    }

    public void setWashState(WashState washState){
        this.washState = washState;
        System.out.println("STATE: " + this.washState.getState());
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        this.washState.setState();
    }

    private void startCarWash(){
        setWashState(new StartState(this));
    }

    public void carWash(int numberOfTimes){
        for (int counter = 0;counter < numberOfTimes;counter++){
            this.startCarWash();
        }
    }



    public static void main(String[] args) {
        CarWash carWash = new PlatinumCarWash();
        carWash.carWash(2);
    }

}
