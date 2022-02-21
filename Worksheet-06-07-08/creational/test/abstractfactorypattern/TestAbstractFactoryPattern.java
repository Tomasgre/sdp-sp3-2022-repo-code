package abstractfactorypattern;

public class TestAbstractFactoryPattern {
  public static void main(String[] args) {

    XMLParser parser;
    String msg;
    AbstractParserFactory parserFactory = ParserFactoryProducer.getFactory("NYCFactory");
    if (parserFactory != null) {
      parser = parserFactory.getParserInstance("NYCORDER");
      msg = parser.parse();
      System.out.println(msg);

      parser = parserFactory.getParserInstance("NYCERROR");
      msg = parser.parse();
      System.out.println(msg);

      parser = parserFactory.getParserInstance("NYCFEEDBACK");
      msg = parser.parse();
      System.out.println(msg);

      parser = parserFactory.getParserInstance("NYCRESPONSE");
      msg = parser.parse();
      System.out.println(msg);
    } else {
      System.out.println("No such factory");
    }


    System.out.println("************************************");

    parserFactory = ParserFactoryProducer.getFactory("LDNFactory");
    if (parserFactory != null) {
      parser = parserFactory.getParserInstance("LDNFEEDBACK");
      msg = parser.parse();
      System.out.println(msg);

      parser = parserFactory.getParserInstance("LDNORDER");
      msg = parser.parse();
      System.out.println(msg);

      parser = parserFactory.getParserInstance("LDNERROR");
      msg = parser.parse();
      System.out.println(msg);

      parser = parserFactory.getParserInstance("LDNRESPONSE");
      msg = parser.parse();
      System.out.println(msg);
    } else {
      System.out.println("No such factory");
    }
  }
}
