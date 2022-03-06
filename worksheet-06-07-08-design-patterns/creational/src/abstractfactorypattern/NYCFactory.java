package abstractfactorypattern;

public class NYCFactory implements AbstractParserFactory {


    @Override
    public XMLParser getParserInstance(String parserType) {

        switch (parserType) {
            case "NYCERROR":
                return new NYCErrorXMLParser();
            case "NYCFEEDBACK":
                return new NYCFeedbackXML();
            case "NYCORDER":
                return new NYCOrderXMLParser();
            case "NYCRESPONSE":
                return new NYCResponseXMLParser();
        }
        return null;
    }


    private class NYCErrorXMLParser implements XMLParser {
        @Override
        public String parse() {
            System.out.println("NY Parsing error XML...");
            return "NY Error XML Message";
        }
    }

    private class NYCFeedbackXML implements XMLParser {
        @Override
        public String parse() {
            System.out.println("NY Parsing feedback XML...");
            return "NY Feedback XML Message";
        }
    }

    private class NYCOrderXMLParser implements XMLParser {
        @Override
        public String parse() {
            System.out.println("NY Parsing order XML...");
            return "NY Order XML Message";
        }
    }

    private class NYCResponseXMLParser implements XMLParser {
        @Override
        public String parse() {
            System.out.println("NY Parsing response XML...");
            return "NY Response XML Message";
        }
    }
}
