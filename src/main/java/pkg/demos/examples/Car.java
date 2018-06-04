package pkg.demos.examples;


interface Vehicle{
    default void print(){
        System.out.println("Soy un vehiculo");
    }
    
    static void blowHorn(){
        System.out.println("bip bip!!!");
    }
}

interface FourWheeler{
    default void print(){
        System.out.println("Tengo 4 ruedas");
    }
}

public class Car implements Vehicle, FourWheeler {
    public void print(){
        System.out.println("\nDemo Interfaces:");
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("Soy un auto");
    }
}
