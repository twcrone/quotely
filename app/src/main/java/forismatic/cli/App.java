package forismatic.cli;

import org.checkerframework.checker.units.qual.C;

public class App {

    public static void main(String[] args) {
        String language = "English";
        if(args.length > 0) {
            language = args[0];
        }
        Client client = new Client();
        Quote quote = client.getQuote(language, System.currentTimeMillis());
        System.out.println();
        if(quote != null) {
            System.out.println(quote.getDisplay());
        }
        else {
            System.out.println("There was an issue fetching a quote.  Please try again later.");
        }
    }
}
