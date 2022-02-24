package factory;

public class BudgetKnifeFactory implements KnifeFactory {

    public Knife create(String type) {
        Knife k = null;
        if (type.equals("chef")) {
            k = new ChefsKnife();
        } else if (type.equals("utility")) {
            k = new UtilityKnife();
        }
        // .... complicated and ugly stuff to
        // figure out what kind of knife to create

        return k;
    }

}
