package pkg.desing.patterns.creational.singleton;

import java.util.Date;
import java.text.SimpleDateFormat;


public class EagerInitializedSingleton {
    
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    
    private Date dInit;
    
    private EagerInitializedSingleton(){
        this.dInit = new Date();
    }
    
    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
    
    public String getInicializacion(){
        return (new SimpleDateFormat("HH.mm.ss").format(this.dInit));
    }
}
