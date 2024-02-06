import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        double cotacao_dolar = 5;

        System.out.println("Conversor de Moedas\n");

        System.out.print("Digete o valor em dólar para saber em real: ");
        double valor = scan.nextDouble();

        double resultado = cotacao_dolar * valor;

        System.out.println("O valor em dólar é: " + resultado);

        scan.close();

    }
}
