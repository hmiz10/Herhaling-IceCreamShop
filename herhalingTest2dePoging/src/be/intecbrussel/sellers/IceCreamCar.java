package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamCar implements IceCreamSeller {

    private PriceList priceList;
    private Stock stock;
    private double profit;

    public IceCreamCar( PriceList priceList, Stock stock){
        this.priceList = priceList;
        this.stock = stock;
    }

    private Cone prepareCone(Cone.Flavor[] flavors) throws NoMoreIceCreamException {
        Cone cone = new Cone();
        if(stock.getBalls() < flavors.length){
            throw new NoMoreIceCreamException();
        } else if (stock.getCones() == 0){
            throw new NoMoreIceCreamException();
        } else {
            stock.setCones(stock.getCones() - 1);
            stock.setBalls(stock.getBalls() - flavors.length);

            this.profit += priceList.getBallPrice() * flavors.length;
            return cone;
        }
    }

    private IceRocket prepareIceRocket() throws NoMoreIceCreamException {
        IceRocket iceRocket = new IceRocket();
        if (stock.getIceRockets() == 0){
            throw new NoMoreIceCreamException();
        } else {
            stock.setIceRockets(stock.getIceRockets() - 1);
            this.profit += priceList.getRocketPrice();

            return iceRocket;
        }

    }

    private Magnum prepareMagnum(Magnum.MagnumType magnumType) throws NoMoreIceCreamException {
        Magnum magnum = new Magnum();
        if (stock.getMagni() ==  0){
            throw new NoMoreIceCreamException();
        } else {
            stock.setMagni(stock.getMagni() - 1);
            this.profit += priceList.getMagnumPrice(magnumType);

            return magnum;
        }
    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) throws NoMoreIceCreamException {
        Cone cone = prepareCone(flavors);
        return cone;
    }

    @Override
    public IceRocket orderIceRocket() throws NoMoreIceCreamException {
        IceRocket iceRocket = prepareIceRocket();
        return iceRocket;
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) throws NoMoreIceCreamException {
        Magnum magnum = prepareMagnum(magnumType);

        return magnum;
    }

    @Override
    public double getProfit() {
        return profit;
    }
}
