package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.NoMoreIceCreamException;
import be.intecbrussel.sellers.PriceList;

public class IceCreamApp {
    public static void main(String[] args) throws NoMoreIceCreamException {

        PriceList priceList = new PriceList();

        priceList.setBallPrice(3.80);
        priceList.setRocketPrice(2.65);
        priceList.setMagnumStandardPrice(10.00);

        IceCreamSeller iceCreamSalon = new IceCreamSalon(priceList);

        Cone.Flavor[] flavors = {Cone.Flavor.BANANA, Cone.Flavor.LEMON, Cone.Flavor.PISTACHE};

        Cone cone = iceCreamSalon.orderCone(flavors);
        IceRocket iceRocket = iceCreamSalon.orderIceRocket();
        Magnum magnum = iceCreamSalon.orderMagnum(Magnum.MagnumType.ALPINENUTS);

        Eatable[] eatable = {cone, iceRocket, magnum};

        for (Eatable eatable1 : eatable){
            eatable1.eat();
        }
        System.out.println("We have made a profit of " + iceCreamSalon.getProfit() + " euros.");
    }
}
