package quotes;


import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class App {

    public static void main(String[] args) {

        String path = "src/main/resources/quotes.json";

        Quote[] quotesFromJson;

        try {
            quotesFromJson = readQuote(path);
            Quote outputQuote = getRandomQuote(quotesFromJson);
            String outputText = outputQuote.getAuthorAndQuote();
            System.out.println(outputText);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Quote[] readQuote(String path) throws FileNotFoundException {

        Gson gson = new Gson();

        FileReader fileReadJson = new FileReader(path);

        Quote[] quoteList = gson.fromJson(fileReadJson, Quote[].class);

        return quoteList;
    }

    public static Quote getRandomQuote(Quote[] list) {

        int randomQuoteNumber = (int)(Math.random() * list.length);

        return list[randomQuoteNumber];
    }

}
