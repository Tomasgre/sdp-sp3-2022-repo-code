package factorymethod;

import java.time.LocalDate;

public class Creator {

    protected Product factoryMethod(String type) {
        return new ConcreteProduct("Porcelain cup",
                Type.CUP, 15.00, LocalDate.parse("2018-03-12"));
    }

    //protected abstract Product factoryMethod(String type);

}
