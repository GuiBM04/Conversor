package entities;

public class Coin {

    private int id;
    private String name;
    private double value;

    public Coin(String name, double value, int number) {
        setName(name);
        setValue(value);
        setId(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int number) {
        this.id = number;
    }
}
