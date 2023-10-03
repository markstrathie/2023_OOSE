public class EncounterCreator {
    SimpleEncounterFactory factory;
    public EncounterCreator(SimpleEncounterFactory factory) {
        this.factory = factory;
    }

    public Encounter createEncounter(Encounters type) {
        Encounter encounter;

        encounter = factory.createEncounter(type);
        return encounter;
    }
}
