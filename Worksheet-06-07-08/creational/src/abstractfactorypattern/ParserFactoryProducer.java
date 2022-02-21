package abstractfactorypattern;

public class ParserFactoryProducer {

    public static AbstractParserFactory getFactory(String type) {
        if (type.equals("NYCFactory")){
            return new NYCFactory();
        } else if (type.equals("LDNFactory")) {
            return new LDNFactory();
        }
        return null;
    }
}
