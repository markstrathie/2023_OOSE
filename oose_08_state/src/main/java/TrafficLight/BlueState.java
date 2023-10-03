package TrafficLight;

public class BlueState implements ColourState{

    private TrafficLight trafficLight;

    public BlueState(TrafficLight trafficLight){
        this.trafficLight = trafficLight;
    }

    public void setState(){
        this.trafficLight.setColourState(new GreenState(this.trafficLight));
    }

    public String getColour(){
        return LightColour.BLUE.getColour();
    }
}
