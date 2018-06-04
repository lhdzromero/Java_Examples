package pkg.desing.patterns.creational.singleton;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private Date dInit;
    
    private ThreadSafeSingleton(){
        dInit = new Date();
    }
    
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null)
            instance = new ThreadSafeSingleton();
        
        return instance;
    }
    
    
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized(ThreadSafeSingleton.class){
                if(instance == null)
                    instance = new ThreadSafeSingleton();
            }
        }
        
        return instance;
    }
    
    public String getInicializacion(){
        return (new SimpleDateFormat("HH.mm.ss").format(dInit));
    }
    
}
