package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.*;

public class IceCreamAppV2 {

    public static void main(String[] args) throws NoMoreIceCreamException {

        PriceList priceList = new PriceList();
        Stock stock = new Stock();

        priceList.setMagnumStandardPrice(2.33);
        priceList.setRocketPrice(16.50);
        priceList.setBallPrice(10.45);

        stock.setMagni(6);
        stock.setIceRockets(2);
        stock.setBalls(3);
        stock.setCones(1);

        IceCreamSeller iceCreamCar = new IceCreamCar(priceList, stock);
        try {
            Cone.Flavor[] flavors = {Cone.Flavor.LEMON, Cone.Flavor.PISTACHE, Cone.Flavor.STRAWBERRY, Cone.Flavor.VANILLA};

            Cone cone = iceCreamCar.orderCone(flavors);
            IceRocket iceRocket = iceCreamCar.orderIceRocket();
            Magnum magnum = iceCreamCar.orderMagnum(Magnum.MagnumType.ALPINENUTS);

            Eatable[] eatable = {cone, iceRocket, magnum};

            for (Eatable eatables : eatable) {
                eatables.eat();
            }
        } catch (NoMoreIceCreamException nmice) {
            System.out.println("No order are permitted " + nmice.getMessage());
        }
            System.out.println("We have made a profit of " + iceCreamCar.getProfit() + " euros!");
    }

}