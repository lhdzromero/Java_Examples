package pkg.desing.patterns.structural.flyweight;

@FunctionalInterface
public interface Order {
    void serve();
    
    static Order of(String flavourName, int tableNumber){
        CoffeeFlavour flavour = CoffeeFlavour.intern(flavourName);
        return ()-> System.out.println("Serving " + flavour + " to table " + tableNumber);
    }
}
