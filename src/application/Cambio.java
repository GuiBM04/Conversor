package application;

import entities.Coin;

import java.util.ArrayList;
import java.util.List;

public class Cambio {

    private List<Coin> coins = new ArrayList<>();
    private int numberOfCoins = 0;

    public Cambio() {
        loadCoins();
    }

    public double convert(int value1, int value2) {
        Coin coin1 = null;
        Coin coin2 = null;
        for(Coin c : coins) {
            if(c.getNumber() == value1) {
                coin1 = c;
            }
        }
        for(Coin c : coins) {
            if(c.getNumber() == value2) {
                coin2 = c;
            }
        }

        return (coin1.getValue() * coin2.getValue());
    }

    public void printOptions(int exception) {
        for(Coin c : coins) {
            if(exception == c.getNumber()) {
                System.out.print("");
            } else {
                System.out.println("Selecione " + c.getNumber() + " para " + c.getName());
            }
        }
    }

    private void loadCoins() {
        coins.add(new Coin("dolar", 5, numberOfCoins + 1));
        numberOfCoins = numberOfCoins + 1;

        coins.add(new Coin("euro", 5.5, numberOfCoins + 1));
        numberOfCoins = numberOfCoins + 1;
    }

    public Coin getCoin(int number) {
        if(number <= 0 || number > numberOfCoins) {
            return null;
        }

        for(Coin c : coins) {
            if(c.getNumber() == number) {
                return c;
            }
        }

        return null;
    }

}
