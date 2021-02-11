package forismatic.cli;

public class Quote {
  private final String text;
  private final String author;

  public Quote(String text) {
    if(text == null) {
      throw new IllegalArgumentException("'text' for Quote must not be null");
    }
    if(text.isBlank()) {
      throw new IllegalArgumentException("'text' for Quote should not be blank");
    }
    int startAuthor = text.lastIndexOf("(");
    int endAuthor = text.lastIndexOf(")");
    if(startAuthor != -1 && endAuthor != -1 && startAuthor < endAuthor) {
      this.author = text.substring(startAuthor + 1, endAuthor);
      this.text = text.substring(0, startAuthor).trim();
    }
    else {
      this.author = "Anonymous";
      this.text = text;
    }
  }

  public String getText() {
    return text;
  }

  public String getAuthor() {
    return author;
  }
}
