package application;

import entities.Coin;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class UI {
    private final Scanner scan;
    Cambio cambio;

    public UI(Cambio cambio) {
        scan = new Scanner(System.in);
        this.cambio = cambio;
    }

    public void printIntro() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Conversor de uma moeda para outra");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
    }

    public Coin getBase() {
        System.out.println("Escolha uma moeda como base:");
        printOptions(cambio.getNumberOfCoins(), 0);

        System.out.print("\nSelecione: ");
        int id = getIntValue(cambio.getNumberOfCoins(), 0);
        System.out.println("\n \n");

        return cambio.getCoin(id);
    }

    public Coin getTarget(Coin base) {
        System.out.println("Escolha uma moeda como alvo:");
        printOptions(cambio.getNumberOfCoins(), base.getId());

        System.out.print("\nSelecione: ");
        int id = getIntValue(cambio.getNumberOfCoins(), base.getId());
        System.out.println("\n \n");

        return cambio.getCoin(id);
    }

    public double getValue() {
        System.out.print("Selecione o valor: ");

        double value = scan.nextDouble();

        System.out.println("\n \n");

        return value;
    }

    public void printResult(double result) {

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        System.out.println(decimalFormat.format(result));
    }

    public void printOptions(int numberOfCoins, int exception) {
        for(int i = 1; i <= numberOfCoins; i++) {
            if(i == exception) {
                System.out.print("");
            } else {
                cambio.printOption(i);
            }
        }
    }

    public int getIntValue(int numberOfCoins, int exception) {
        int value = scan.nextInt();

        while(!(value != exception && value > 0 && value <= numberOfCoins)) {
            System.out.println(("Incorreto. Tente novamente"));
            System.out.print("Selecione: ");
            value = scan.nextInt();
        }

        return value;
    }

    public void close() {
        scan.close();
    }

}
