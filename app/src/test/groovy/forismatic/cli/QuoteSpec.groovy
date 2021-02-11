package forismatic.cli

import spock.lang.Specification

class QuoteSpec extends Specification {

    def "Make sure some standard quote text doesn't suddenly start failing"() {
        given:
        def testFile = new File("src/test/resources/quotes.txt")
        String line

        when:
        testFile.withReader {reader ->
            while((line = reader.readLine()) != null) {
                new Quote(line)
            }
        }

        then:
        notThrown(Exception)
    }

    def "Client can parse quote correctly"() {
        when:
        def quote = new Quote(text)

        then:
        quote.author == expectedAuthor
        quote.text == expectedText

        where:

        text                ||  expectedText    |   expectedAuthor
        "Quote (Author)"    ||  "Quote"         |   "Author"
        "Quote only"        ||  "Quote only"    |   "Anonymous"
    }
}
