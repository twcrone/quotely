package forismatic.cli;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {

  private final String BASE_URI = "http://api.forismatic.com/api/1.0/?method=getQuote&key=";
  private final HttpClient httpClient = HttpClient.newBuilder()
      .version(HttpClient.Version.HTTP_1_1)
      .build();

  public Quote getQuote(String language, Long key) {
    String languageParameter = getLanguageParameter(language);
    Quote quote = null;
    try {
      URI uri = new URI(BASE_URI + key + "&format=text&lang=" + languageParameter);
      HttpRequest request = HttpRequest.newBuilder()
          .uri(uri)
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

  private static String getLanguageParameter(String language) {
    String parameter;
    if(language == null || language.isBlank() || "English".equals(language)) {
      parameter = "en";
    }
    else if("Russian".equals(language)) {
      parameter = "ru";
    }
    else {
      String message = language + " is not a valid language.  Try 'English' or 'Russian'";
      throw new IllegalArgumentException(message);
    }
    return parameter;
  }
}
