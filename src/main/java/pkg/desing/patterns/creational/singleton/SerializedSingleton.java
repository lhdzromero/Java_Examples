package pkg.desing.patterns.creational.singleton;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;

public class SerializedSingleton implements Serializable {
   private static final long serialVersionUID = -7604766932017737115L;
   
   private Date dInit;
   
   private SerializedSingleton(){
       dInit = new Date(); 
   }
   
   private static class SingletonHelper {
       private static final SerializedSingleton instance = new SerializedSingleton();
   }
   
   public static SerializedSingleton getInstance(){
       return SingletonHelper.instance;
   }
   
   public String getInicializacion(){
       return (new SimpleDateFormat("HH.mm.ss").format(dInit));
   }
   
   protected Object readResolve(){
       return getInstance();
   }
}
