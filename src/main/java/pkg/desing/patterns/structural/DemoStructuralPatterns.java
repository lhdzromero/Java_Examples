package pkg.desing.patterns.structural;

import javax.naming.Reference;

import pkg.desing.patterns.structural.adapter.Volt;
import pkg.desing.patterns.structural.adapter.SocketAdapter;
import pkg.desing.patterns.structural.adapter.SocketClassAdapterImpl;
import pkg.desing.patterns.structural.adapter.SocketObjectAdapterImpl;
import pkg.desing.patterns.structural.composite.Shape;
import pkg.desing.patterns.structural.composite.Triangule;
import pkg.desing.patterns.structural.composite.Circule;
import pkg.desing.patterns.structural.composite.DrawingShape;
import pkg.desing.patterns.structural.proxy.CommandExecutor;
import pkg.desing.patterns.structural.proxy.CommandExecutorProxy;
import pkg.desing.patterns.structural.bridge.*;

public class DemoStructuralPatterns {
    
    public static void DemoStructural(){
        System.out.println("\nDemo Structural Pattern...");
        DemoAdapterPattern();
        DemoCompositePattern();
        DemoProxyPattern();
        DemoBridgePattern();
    }
    
    private static void DemoAdapterPattern(){
        System.out.println("\nAdapter Pattern...");
        testClassAdapter();
        testObjectAdapter();
    }
    
    
    private static void testClassAdapter(){
        System.out.println("Class Adapter...");
        
        SocketAdapter socketAdapt = new SocketClassAdapterImpl();
        Volt v3 = getVolt(socketAdapt, 3);
        Volt v12 = getVolt(socketAdapt, 12);
        Volt v120 = getVolt(socketAdapt, 120);
         
        System.out.println("v3 volts using Class Adapter = " + v3.getVolts());
        System.out.println("v12 volts using Class Adapter = " + v12.getVolts());
        System.out.println("v120 volts using Class Adapter = " + v120.getVolts());
        
    }
    
    private static void testObjectAdapter(){
        System.out.println("\nObject Adapter...");
        
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
   
   private static void DemoCompositePattern(){
       System.out.println("\nComposite Pattern...");
       
       Shape tri = new Triangule();
       Shape tri1 = new Triangule();
       Shape cir = new Circule();
      
      DrawingShape drawing = new DrawingShape();
      drawing.add(tri);
      drawing.add(tri1);
      drawing.add(cir);
      
      drawing.draw("Red");
      
      drawing.clear();
      
      drawing.add(tri);
      drawing.add(cir);
      
      drawing.draw("Green"); 
   }
   
   private static void DemoProxyPattern(){
       System.out.println("\nProxy Pattern...");
       CommandExecutor executor = new CommandExecutorProxy("Sandip" , "wrong_pwd");
       try {
            executor.runCommand("ls -ltr");
            executor.runCommand("echo Hola Luis");
            executor.runCommand("rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::" + e.getMessage());
        }
   }
   
   private static void DemoBridgePattern(){
       System.out.println("\nBridge Pattern...");
       
       pkg.desing.patterns.structural.bridge.Shape tri = new pkg.desing.patterns.structural.bridge.Triangule(new RedColor());
       tri.applyColor();
       
       pkg.desing.patterns.structural.bridge.Shape pent = new Pentagon(new GreenColor());
       pent.applyColor();
       
       pent = new Pentagon(new BlueColor());
       pent.applyColor();
       
       System.out.println("");
   }
   
   
}
