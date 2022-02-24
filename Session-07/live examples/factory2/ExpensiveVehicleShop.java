package factory2;

import java.lang.reflect.InvocationTargetException;

public class ExpensiveVehicleShop extends VehicleShop {

    // Reflection if you're often adding new classes...
    @Override
    public Vehicle create(String name) {
        try {
            return
                (Vehicle)
                    Class.forName(name).getDeclaredConstructor(String.class).newInstance("Expensive " + name);
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }
}
