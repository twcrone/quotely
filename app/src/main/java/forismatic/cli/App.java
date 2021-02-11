package forismatic.cli;

public class App {

  public static void main(String[] args) {
    String language = "English";
    if (args.length > 0) {
      language = args[0];
    }
    System.out.println();
    Quote quote = tryToGetQuote(language);
    if (quote != null) {
      System.out.println(quote.getDisplay());
    } else {
      System.out.println("There was an issue fetching a quote.  Please try again later.");
    }
  }

  private static Quote tryToGetQuote(String language) {
    try {
      Client client = new Client();
      return client.getQuote(language, System.currentTimeMillis());
    } catch (Exception e) {
      return new Quote(e.getMessage());
    }
  }
}
