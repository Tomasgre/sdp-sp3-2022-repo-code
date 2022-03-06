package factorymethod;

import java.time.LocalDate;

public class ConcreteCreator extends Creator {

    @Override
    public Product factoryMethod(String type) {

        switch (type.toLowerCase()) {
            case "b":
            case "bowl":
                return new ConcreteProduct("Slipware bowl",
                    Type.BOWL, 145.00, LocalDate.parse("1930-01-08"));
            case "c":
            case "cup":
                return new ConcreteProduct("Salt glaze mug",
                    Type.CUP, 45.00, LocalDate.parse("1990-01-08"));
            case "v":
            case "vase":
                return new ConcreteProduct("Nake raku vase",
                    Type.VASE, 649.89, LocalDate.parse("1989-04-18"));
        }

        return null;
    }

}
