package pkg.desing.patterns.creational.singleton;

import java.util.Date;
import java.text.SimpleDateFormat;

public class LazyInitializedSingleton {
    
    private static LazyInitializedSingleton instance = null; //Es necesario igualarla  a null para que funcione
    private Date dInit;
    
    private LazyInitializedSingleton (){
        this.dInit = new Date();
    }
    
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        
        return instance;
    }
    
    public String getInitialization(){
        return (new SimpleDateFormat("HH.mm.ss").format(dInit));
    }
}
