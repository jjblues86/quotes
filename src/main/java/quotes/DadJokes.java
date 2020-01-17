package quotes;

import java.util.List;

public class DadJokes{
    public String fallback;
    List<Attachments> attachments;

//    public DadJokes(String[] attachments) {
//        this.attachments = attachments;
//    }

    public List<Attachments> dadJokesApi(){
        return attachments;
    }

    public String toString() {
        return attachments.get(0).toString();
//        return attachments.toString();
    }
}
