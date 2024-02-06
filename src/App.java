import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        double dolar = 5;

        System.out.println("Conversor de Moedas\n");

        System.out.print("Digete o valor em real para saber em dólar: ");
        double valor = scan.nextDouble();

        double resultado = dolar * valor;

        System.out.println("O valor em dólar é: " + resultado);

        scan.close();

    }
}
