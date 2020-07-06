package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;


public class IceCreamSalon implements IceCreamSeller {

    private PriceList priceList;
    private double totalProfit;


    public IceCreamSalon (PriceList priceList){
        this.priceList = priceList;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
        Cone cone = new Cone();
        this.totalProfit = totalProfit + (priceList.getBallPrice() * flavors.length);

        return cone;
    }

    @Override
    public IceRocket orderIceRocket() {
        IceRocket iceRocket = new IceRocket();
        this.totalProfit = totalProfit + priceList.getRocketPrice();

        return iceRocket;
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) {
        Magnum magnum = new Magnum();
        this.totalProfit = totalProfit + priceList.getMagnumPrice(magnumType);

        return magnum;
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }

    @Override
    public String toString() {
        return "IceCreamSalon{" + "priceList=" + priceList + ", totalProfit=" + totalProfit + '}';
    }
}
