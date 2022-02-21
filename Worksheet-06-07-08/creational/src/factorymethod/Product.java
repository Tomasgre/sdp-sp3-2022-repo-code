package factorymethod;

import java.time.LocalDate;

public interface Product {

    double getPrice();
    Type getType();
    LocalDate getDateMade();
    String getName();

}
