package forismatic.cli;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {

  private final HttpClient httpClient = HttpClient.newBuilder()
      .version(HttpClient.Version.HTTP_1_1)
      .build();

  public Quote getQuote(String language, Long key) {
    Quote quote = null;
    try {
      HttpRequest request = HttpRequest.newBuilder()
          .uri(new URI("http://api.forismatic.com/api/1.0/?method=getQuote&key=" + key + "&format=text&lang=en"))
          .GET()
          .build();
      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
      String text = response.body();
      quote = new Quote(text);
    } catch (URISyntaxException | InterruptedException | IOException e) {
      e.printStackTrace();
    }
    return quote;
  }
}
