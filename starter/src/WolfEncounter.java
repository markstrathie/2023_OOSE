public class WolfEncounter extends Encounter {

    public WolfEncounter() {
        name = "Wolf";
        nearbyAlert = "hear distant howling.";
        printout = "You are attacked by wolves!";
    }


    public void effect() {
        //Deal 20 damage to the player
    }
}
