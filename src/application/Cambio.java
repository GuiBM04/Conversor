package application;

import entities.Coin;

import java.util.ArrayList;
import java.util.List;

public class Cambio {

    private List<Coin> coins = new ArrayList<>();
    private int numberOfCoins = 0;

    public Cambio() {

    }

    public double convert(Coin base, Coin target, double value) {
        return value / (target.getValue() / base.getValue());

    }

    public void loadCoins() {
        coins.add(new Coin("real", 1, numberOfCoins + 1));
        numberOfCoins = numberOfCoins + 1;

        coins.add(new Coin("dolar", 5, numberOfCoins + 1));
        numberOfCoins = numberOfCoins + 1;

        coins.add(new Coin("euro", 5.5, numberOfCoins + 1));
        numberOfCoins = numberOfCoins + 1;
    }

    public void printOption(int id) {
        Coin coin = getCoin(id);
        System.out.println("Selecione " + coin.getId() + " para " + coin.getName());
    }

    public Coin getCoin(int id) {
        if(id <= 0 || id > numberOfCoins) {
            return null;
        }

        for(Coin c : coins) {
            if(c.getId() == id) {
                return c;
            }
        }

        return null;
    }

    public int getNumberOfCoins() {
        return numberOfCoins;
    }

}
