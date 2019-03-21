package pkg.desing.patterns.structural;

import pkg.desing.patterns.structural.adapter.Volt;
import pkg.desing.patterns.structural.adapter.SocketAdapter;
import pkg.desing.patterns.structural.adapter.SocketClassAdapterImpl;
import pkg.desing.patterns.structural.adapter.SocketObjectAdapterImpl;

public class DemoStructuralPatterns {
    
    public static void DemoStructural(){
        testClassAdapter();
        testObjectAdapter();
    }
    
    private static void testClassAdapter(){
        SocketAdapter socketAdapt = new SocketClassAdapterImpl();
        Volt v3 = getVolt(socketAdapt, 3);
        Volt v12 = getVolt(socketAdapt, 12);
        Volt v120 = getVolt(socketAdapt, 120);
        
        System.out.println("v3 volts using Class Adapter = " + v3.getVolts());
        System.out.println("v12 volts using Class Adapter = " + v12.getVolts());
        System.out.println("v120 volts using Class Adapter = " + v120.getVolts());
        
    }
    
    private static void testObjectAdapter(){
        SocketAdapter socketAdapt = new SocketObjectAdapterImpl();
        Volt v3 = getVolt(socketAdapt, 3);
        Volt v12 = getVolt(socketAdapt, 12);
        Volt v120 = getVolt(socketAdapt, 120);
        
        System.out.println("v3 volts using Object Adapter = "+ v3.getVolts());
        System.out.println("v12 volts using Object Adapter = "+ v12.getVolts());
        System.out.println("v10 volts using Object Adapter = "+ v120.getVolts());
    }
    
    private static Volt getVolt(SocketAdapter sadp, int i){
        switch (i) {
            case 3: return sadp.get3Volt();
            case 12: return sadp.get12Volt();
            case 120: return sadp.get120Volt();
            default: return sadp.get120Volt();
        }
   }
    
     
}
