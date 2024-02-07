package entities;

public class Coin {
    private String name;
    private double value;
    private int number;

    public Coin(String name, double value, int number) {
        setName(name);
        setValue(value);
        setNumber(number);
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
