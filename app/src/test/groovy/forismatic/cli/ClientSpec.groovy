package forismatic.cli

import spock.lang.Specification

class ClientSpec extends Specification {

    def "Client can get a greeting"() {
        given:
        def client = new Client()
        def quotes = []

        when:
        1000.times {quotes << client.getQuote("English", it) }

        then:
        quotes.every { it != null }
    }

    def "Client can parse quote correctly"() {
        given:
        String jsonWithUnescaptedQuotes
    }
}
