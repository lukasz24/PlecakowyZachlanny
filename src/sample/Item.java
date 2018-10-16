package sample;

public class Item {
    int value;
    int weight;
    float ratio;
    String name;

    public Item(int value, int weight, String name) {
        this.value = value;
        this.weight = weight;
        this.ratio = (float) value/weight;
        this.name = name;
    }

    public int getValue() {
        return value;
    }
    public int getWeight() {
        return weight;
    }
    public float getRatio() {
        return ratio;
    }
    public String getName() {
        return name;
    }
}
