package pkg.desing.patterns.creational.singleton;

import java.util.Date;
import java.text.SimpleDateFormat;


public class BillPughSingleton {
    
    private Date dInit;
    
    private BillPughSingleton (){
        dInit = new Date();
    }
    
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
    
    public String getInicializacion(){
        return (new SimpleDateFormat("HH.mm.ss").format(dInit));
    }
    
}
