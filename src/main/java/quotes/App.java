package quotes;


import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {


    public static void main(String[] args) {

        String URL = "https://icanhazdadjoke.com/slack";
        displayJokesToTerminal(URL);
    }


    public static void displayJokesToTerminal(String URL){

        try {
            readQuoteFromApi(URL);
        } catch (IOException e) {
            readQuoteFromLocalMachine();
        }

    }

    public static void readQuoteFromApi(String URL) throws IOException {


        URL iCanHaveBadJokesUrl= new URL(URL);

        HttpURLConnection connect = (HttpURLConnection) iCanHaveBadJokesUrl.openConnection();
        connect.setRequestMethod("GET");

        BufferedReader inputString = new BufferedReader(
                new InputStreamReader(connect.getInputStream()));

        StringBuilder quotesString = new StringBuilder();
        String firstJokeLine = inputString.readLine();

        while(firstJokeLine != null){
            quotesString.append(firstJokeLine);
           firstJokeLine = inputString.readLine();
        }

        Gson gson = new Gson();
        DadJokes dadJoke = gson.fromJson(quotesString.toString(), DadJokes.class);
        System.out.println("dadJoke = " + dadJoke.toString());


        // write to json file
        File localMachineJsonQuotesFile = new File("src/main/resources/quotesDAD.json");
        FileWriter quoteFileWriter = new FileWriter(localMachineJsonQuotesFile, true);

        BufferedWriter buffWriter = new BufferedWriter(quoteFileWriter);
        buffWriter.newLine();
        buffWriter.append(quotesString.toString());
        buffWriter.newLine();
        buffWriter.close();
    }

    public static void readQuoteFromLocalMachine(){

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

