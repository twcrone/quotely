package forismatic.cli

import spock.lang.Specification

class ClientSpec extends Specification {

    def "Client can get a quote"() {
        given:
        def client = new Client()
        def quotes = []

        when:
        10.times {quotes << client.getQuote("English", it) }

        then:
        quotes.every { it != null }
    }
}
