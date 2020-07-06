package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Magnum;

public class PriceList {

    private double ballPrice;
    private double rocketPrice;
    private double magnumStandardPrice;

    public PriceList(){
       this(0, 0, 0);
    }

    public PriceList(double ballPrice, double rocketPrice, double magnumStandardPrice){
        this.ballPrice = ballPrice;
        this.rocketPrice = rocketPrice;
        this.magnumStandardPrice = magnumStandardPrice;
    }

    public double getBallPrice() {
        return ballPrice;
    }

    public void setBallPrice(double ballPrice) {
        this.ballPrice = ballPrice;
    }

    public double getRocketPrice() {
        return rocketPrice;
    }

    public void setRocketPrice(double rocketPrice) {
        this.rocketPrice = rocketPrice;
    }

    public double getMagnumPrice(Magnum.MagnumType magnumType) {

        if(magnumType == Magnum.MagnumType.ALPINENUTS){
            double magnumPrice = 1.50 * magnumStandardPrice;
        }

        if(magnumType == Magnum.MagnumType.WHITECHOCOLATE){
            double magnumPrice = 1.90 * magnumStandardPrice;
        }

        if(magnumType == Magnum.MagnumType.MILKCHOCOLATE){
            double magnumPrice = 6.20 * magnumStandardPrice;
        }

        if(magnumType == Magnum.MagnumType.BLACKCHOCOLATE){
            double magnumPrice = 2.10 * magnumStandardPrice;
        }

        if(magnumType == Magnum.MagnumType.ROMANTICSTRAWBERRIES){
            double magnumPrice = 3.65 * magnumStandardPrice;
        }

        return magnumStandardPrice;
    }

    public void setMagnumStandardPrice(double magnumStandardPrice) {
        this.magnumStandardPrice = magnumStandardPrice;
    }
}
