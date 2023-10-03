package carwash;
public enum CarWashStage {
    TAKEMONEY("Take Money"),
    START("Start"),
    CARBODY("Wash Car Body"),
    WHEEL("Wash Wheel"),
    DRY("Dry"),
    POLISH("Polish"),
    FINISH("Finish");

    private CarWashStage(String stage){
        this.stage = stage;
    }

    private final String stage;

    public String getStage(){
        return stage;
    }

}
