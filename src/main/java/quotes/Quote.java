package quotes;


public class Quote {

    public String[] tags;
    public String author;
    public String likes;
    public String text;

    public String getAuthorAndQuote() {
        return String.format("Author: %s,\nQuote: %s", this.author, this.text);
    }

}
