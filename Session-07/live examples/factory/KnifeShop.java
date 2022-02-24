package factory;

public class KnifeShop {


    public Knife order(String type, Boolean isLuxury) {

        KnifeFactory kf;

        if (isLuxury) {
            kf = new LuxuryKnifeFactory();
        } else {
            kf = new BudgetKnifeFactory();
        }

        Knife k = kf.create(type);

        if (k != null) {
            k.polish();
            k.sharpen();
        }
        return k;
    }

}
