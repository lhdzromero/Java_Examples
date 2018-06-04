package pkg.desing.patterns.creational.singleton;

import java.util.Date;
import java.text.SimpleDateFormat;

public class StaticBlockSingleton {
    private static StaticBlockSingleton instance;
    
    private Date dInit; 
    
    private StaticBlockSingleton(){
        this.dInit = new Date();
    }
    
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception ex){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static StaticBlockSingleton getInstance(){
        return instance;
    } 
    
    public String getInitialization(){
        return (new SimpleDateFormat("HH.mm.ss").format(dInit));
    }
}
