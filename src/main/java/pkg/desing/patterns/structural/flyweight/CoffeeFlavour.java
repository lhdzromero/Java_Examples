package pkg.desing.patterns.structural.flyweight;

import java.util.WeakHashMap;

public class CoffeeFlavour {
    private final String name;
    private static final WeakHashMap<String, CoffeeFlavour> CACHE = new WeakHashMap<>();
    
    private CoffeeFlavour(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
    public static CoffeeFlavour intern(String name){
        synchronized(CACHE){
            return CACHE.computeIfAbsent(name, CoffeeFlavour::new);
        }
    }
    
    public static int flavourInCache(){
        synchronized (CACHE) {
            return CACHE.size();
        }
    }
}
