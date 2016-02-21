package Model;

// a Location in the game world of Dark Souls
public enum Location {
    NUA("Northern Undead Asylum"), FLink("Firelink Shrine"), UBurg("Undead Burg"),
    UParish("Undead Parish"), Depths("Depths"), Valley("Valley of the Drakes"),
    BTown("Blighttown"), Que("Quelaag's Domain"), LBurg("Lower Undead Burg"),
    Tree("The Great Hollow"), Lake("The Great Hollow"), Fort("Sen's Fortress"),
    Anor("Anor Londo"), Paint("Painted World of Ariamis"),
    Garden("Darkroot Garden"), Basin("Darkroot Basin"), NLRuins("New Londo Ruins"),
    Duke("The Duke's Archives"), Cave("Crystal Cave"), DRuins("Demon Ruins"),
    Izalith("Lost Izalith"), Skeltal("The Catacombs"),
    Tomb("Tomb of the Giants"), Kiln("Kiln of the First Flame");

    // the full name of the level
    private String name;

    Location(String name) {
        this.name = name;
    }

    /**
     * get the full name of the location
     * @return the name of the level
     */
    public String getName() {
        return name;
    }
}
