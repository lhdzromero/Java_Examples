package pkg.demos.examples;

import java.lang.reflect.Field;


/*
 * https://medium.com/@jomoespe/seguridad-y-microservicios-java-93bbc966d966
 */

public final class HackInmutable {
    
    static final class InmutableEmployee{
        private final int    id;
        private final String name;
        private final Float  salary;
        
        protected InmutableEmployee(final int id, final String name, final Float salary){
            this.id     = id;
            this.name   = name;
            this.salary = salary;
        }
        
        public String name(){
            return name;
        }
    }
    
public static Object giveMe(final Object obj, final String attribute){
    try{
        Field f = obj.getClass().getDeclaredField(attribute);
        f.setAccessible(true);
        return f.get(obj);
    }catch(Exception e){
        return null;  
    }
}

public static void hackIt(final Object obj, final String attribute, final Object newValue){
    try{
        Field f = obj.getClass().getDeclaredField(attribute);
        f.setAccessible(true);
        f.set(obj, newValue);
    }catch(Exception e){
        
    }
}
    
}
