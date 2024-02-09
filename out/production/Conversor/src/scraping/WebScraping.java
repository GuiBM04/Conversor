package scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebScraping {

    public static double scrapDolar() throws IOException {
        Document html = Jsoup.connect("https://economia.uol.com.br/cotacoes/").get();

        return format(html.getElementsByAttributeValue("name", "currency2").toString());
    }

    public static double format(String stringHtml) {
        String[] valueSemComeco = stringHtml.split("value=\"");
        String[] valueSemFinal = valueSemComeco[1].split("\" data-");

        String stringValue = valueSemFinal[0];


        String[] numberVetor = stringValue.split(",");

        String intergerString = numberVetor[0];
        int intergerNumbers = Integer.parseInt(intergerString);

        String decimalString = numberVetor[1];
        int decimalNumbers = Integer.parseInt(decimalString);

        double divisor = Math.pow(10, decimalString.length());


        double value = intergerNumbers + (decimalNumbers / divisor);


        return value;
    }


}
