package pkg.desing.patterns.creational.singleton;

import java.util.Date;
import java.text.SimpleDateFormat;

 
public enum EnumSingleton {
    INSTANCE;
    
  // no need for private constructor
  // no need for getInstance, just use EnumSingleton.INSTANCE
    
    private Date dInit = new Date();
    
    public String getInicializacion(){
        return (new SimpleDateFormat("HH.mm.ss").format(dInit));
    }
}
