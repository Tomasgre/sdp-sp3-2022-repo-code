package abstractfactorypattern;

public class LDNFactory implements AbstractParserFactory {
    @Override
    public XMLParser getParserInstance(String parserType) {

        switch (parserType){
            case "LDNERROR": return new LDNErrorXMLParser();
            case "LDNFEEDBACK": return new LDNFeedbackXML();
            case "LDNORDER": return new LDNOrderXMLParser();
            case "LDNRESPONSE": return new LDNResponseXMLParser();
        }
        return null;
    }


    private class LDNErrorXMLParser implements XMLParser {
        @Override
        public String parse() {
            System.out.println("LDN Parsing error XML...");
            return "LDN Error XML Message";
        }
    }

    private class LDNFeedbackXML implements XMLParser {
        @Override
        public String parse() {
            System.out.println("LDN Parsing feedback XML...");
            return "LDN Feedback XML Message";
        }
    }

    private class LDNOrderXMLParser implements XMLParser {
        @Override
        public String parse() {
            System.out.println("LDN Parsing order XML...");
            return "LDN Order XML Message";
        }
    }

    private class LDNResponseXMLParser implements XMLParser {
        @Override
        public String parse() {
            System.out.println("LDN Parsing response XML...");
            return "LDN Response XML Message";
        }
    }
}
