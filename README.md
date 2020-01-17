# Quotes

## Micah Thorstensen and Jerome Joof

## App.java
- reasQuote()
- getRandomQuote()
- displayJokesToTerminal(String URL)
- readQuoteFromApi(String URL)
- readQuoteFromLocalMachine()
- readQuote(String path)

Given a JSON formatted file containing objects with:  
    ```
    1. String[] tags  
    2. String author  
    3. String likes   
    4. String text   
    ```  
- Feature 1(Create a list of Quote objects from these JSON objects).
- Feature 2(Grab quotes from an API and display those to the user).

## HOW TO RUN:
Run Main method.  Main method returns a String with author and associated quote.

## Dependencies
- implementation 'com.google.code.gson:gson:2.8.6'
- api ```https://icanhazdadjoke.com/slack```

      
