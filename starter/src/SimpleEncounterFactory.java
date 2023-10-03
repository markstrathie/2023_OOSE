public class SimpleEncounterFactory {

    public Encounter createEncounter(Encounters type) {
        Encounter encounter = null;

        if (type.equals(Encounters.FLATLANDS)) {
            encounter = new FlatlandsEncounter();
        } else if (type.equals(Encounters.FINISH_POINT)) {
            encounter = new FinishEncounter();
        } else if (type.equals(Encounters.WOLF)) {
            encounter = new WolfEncounter();
        } else if (type.equals(Encounters.LAKE)) {
            encounter = new LakeEncounter();
        }
        return encounter;
    }
}
