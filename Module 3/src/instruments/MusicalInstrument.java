package instruments;

public class MusicalInstrument {
    String name;
    private MusicalStore store;

    public MusicalInstrument(String name) {
        this.setName(name);
    }

    public MusicalInstrument() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStore(MusicalStore s) {
    }

    public MusicalStore getStore() {
        return store;
    }
}
