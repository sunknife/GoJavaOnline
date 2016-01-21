package flowers;

public class Flower {
    private String name;
    protected FlowerType type;

    public Flower(String name) {
        setName(name);
        type = FlowerType.Unknown;
    }

    public Flower() {

    }

    public FlowerType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}