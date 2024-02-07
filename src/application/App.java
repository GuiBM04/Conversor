package application;

import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        Cambio cambio = new Cambio();
        int valor1;
        int valor2;

        // LOOP
        boolean finish = false;
        while(!finish) {
            // INTRO
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Conversor de uma moeda para outra");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++\n\n");

            // MOEDA BASE
            System.out.println("Selecione uma moeda como base:");
            cambio.printOptions(0);


            // ESCOLHA DA MOEDA BASE
            System.out.print("Escolha: ");
            valor1 = scan.nextInt();
            System.out.println();
            System.out.println("Voce escolheu " + cambio.getCoin(valor1).getName());
            System.out.println("\n");

            // MOEDA ALVO
            System.out.println("Escolha um alvo para converter:");
            cambio.printOptions(cambio.getCoin(valor1).getNumber());

            // ESCOLHA DA MOEDA ALVO
            System.out.print("Escolha: ");
            valor2 = scan.nextInt();
            System.out.println();
            System.out.println("Voce escolheu " + cambio.getCoin(valor2).getName());
            System.out.println("\n");


            // Converter
            System.out.println("O resultado e: " + cambio.convert(valor1, valor2));


            System.out.print("Deseja tentar outro? 1 para sim e 2 para nao: ");
            if(scan.nextInt() == 1) {
                System.out.println("\n \n \n \n");
            } else {
                finish = true;
            }
        }

        scan.close();
    }

//


    
}
