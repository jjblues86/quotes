package quotes;

import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import java.io.FileNotFoundException;


public class TestApp {

    String actualFormattedQuote;
    Quote[] quotesListFromJson;

    @Before
    public void init() {
        String path = "src/main/resources/quotes.json";

        try {

            quotesListFromJson = App.readQuote(path);
            String outputText = App.getRandomQuote(quotesListFromJson).getAuthorAndQuote();
            actualFormattedQuote = outputText;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void app_testReadQuote_ForAppropriateLength() {

        int expectedLength = 138;
        int actualLength = quotesListFromJson.length;
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void app_testGetRandomQuote() {

        int quoteListLength = quotesListFromJson.length;

        for (int i = 0; i < quoteListLength; i++) {
            String nextQuote = String.format("Author: %s,\nQuote: %s", quotesListFromJson[i].author, quotesListFromJson[i].text);
            if (actualFormattedQuote.equals(nextQuote)) {
                assertEquals(actualFormattedQuote, nextQuote);
            }
        }
    }
}
