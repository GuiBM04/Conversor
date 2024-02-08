package application;

import entities.Coin;

public class App {

    public static void main(String[] args) throws Exception {
        Cambio cambio = new Cambio();
        UI ui = new UI(cambio);

        App(cambio, ui);

        ui.close();
    }

    public static void App(Cambio cambio, UI ui) {
        // INTRO
        ui.printIntro();

        // LOAD COINS
        cambio.loadCoins();

        // VARIAVEIS
        Coin base;
        Coin target;
        double value;
        double result;

        // MOEDA BASE
        base = ui.getBase();

        // MOEDA ALVO
        target = ui.getTarget(base);

        // Valor a ser convertido
        value = ui.getValue();

        // Converter
        result = cambio.convert(base, target, value);

        // Show Results
        ui.printResult(result);

    }
}
