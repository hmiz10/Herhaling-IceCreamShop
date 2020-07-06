package be.intecbrussel.eatables;

public class Cone implements Eatable {

    private Flavor[] ballsArray;

    public Cone(){

    }

    public Cone (Flavor[] flavors){
        this.ballsArray = flavors;
    }

    public enum Flavor{
        STRAWBERRY,
        BANANA,
        CHOCOLATE,
        VANILLA,
        LEMON,
        STRACIATELLA,
        MOKKA,
        PISTACHE,
    }


    @Override
    public void eat() {
        System.out.println("I'm eating a Cone.");
    }
}
