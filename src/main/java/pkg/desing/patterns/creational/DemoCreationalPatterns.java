package pkg.desing.patterns.creational;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.List;

import pkg.desing.patterns.creational.abstractfactory.HighEndPhoneFactory;
import pkg.desing.patterns.creational.abstractfactory.LowRangePhoneFactory;
import pkg.desing.patterns.creational.abstractfactory.MidRangePhoneFactory;
import pkg.desing.patterns.creational.abstractfactory.SmartPhone;
import pkg.desing.patterns.creational.abstractfactory.SmartPhoneFactory;
import pkg.desing.patterns.creational.factory.Computer;
import pkg.desing.patterns.creational.factory.ComputerFactory;
import pkg.desing.patterns.creational.prototype.Employees;
import pkg.desing.patterns.creational.singleton.*;

public class DemoCreationalPatterns {
    
    public static void DemoCreationals(DemoCreational demo) {
        try {

            switch (demo) {
                case Singleton:
                    DemoSingleton();
                    break;
                case Factory:
                    DemoFactory();
                    break;

                case AbstractFactory:
                    DemoAbstractFactory(16, 4, 16, 32);
                    DemoAbstractFactory(1, 1, 8, 8);
                    DemoAbstractFactory(2, 4, 13, 16);
                    break;
                case Builder:
                    DemoBuilderPattern();
                    break;
                case Prototype:
                    DemoPrototypePattern();
                    break;
            }
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void DemoSingleton() {
        System.out.println("Método de Inicialización ansiosa Singleton...");
        EagerInitializedSingleton eigs = EagerInitializedSingleton.getInstance();
        System.out.println("Inicializando el 1er Objeto: " + eigs.hashCode() + " " + eigs.getInicializacion());

        EagerInitializedSingleton eigs2 = EagerInitializedSingleton.getInstance();
        System.out.println("Inicializando el 2do Objeto: " + eigs.hashCode() + " " + eigs2.getInicializacion());
        System.out.println("");


        System.out.println("Método de Bloque estático Singleton...");
        StaticBlockSingleton sbs = StaticBlockSingleton.getInstance();
        System.out.println("Inicializando el 1er Objeto: " + sbs.hashCode() + " " + sbs.getInitialization().toString());

        StaticBlockSingleton sbs2 = StaticBlockSingleton.getInstance();
        System.out.println("Inicializando el 2do Objeto: " + sbs.hashCode() + " " + sbs2.getInitialization().toString());
        System.out.println("");

        System.out.println("Método de inicialización perezosa Singleton...");
        LazyInitializedSingleton lis = LazyInitializedSingleton.getInstance();
        System.out.println("Inicializando el 1er Objeto: " + lis.hashCode() + " " + lis.getInitialization());

        LazyInitializedSingleton lis2 = LazyInitializedSingleton.getInstance();
        System.out.println("Inicializando el 2do Objeto: " + lis2.hashCode() + " " + lis2.getInitialization());
        System.out.println("");

        System.out.println("Método de inicialización Segura Singleton...");
        ThreadSafeSingleton tss = ThreadSafeSingleton.getInstance();
        System.out.println("Inicializando el 1er Objeto: " + tss.hashCode() + " " + tss.getInicializacion());

        ThreadSafeSingleton tss2 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
        System.out.println("Inicializando el 2do Objeto: " + tss2.hashCode() + " " + tss2.getInicializacion());
        System.out.println("");

        System.out.println("Método de inicialización Bill Pugh Singleton...");
        BillPughSingleton bps = BillPughSingleton.getInstance();
        System.out.println("Inicializando el primer Objeto: " + bps.hashCode() + " " + bps.getInicializacion().toString());
        BillPughSingleton bps2 = BillPughSingleton.getInstance();
        System.out.println("Inicializando el segundo Objeto: " + bps2.hashCode() + " " + bps2.getInicializacion().toString());
        System.out.println("");

        ReflectionSingletonTest();

        System.out.println("Método Enum Singleton...");
        EnumSingleton es = EnumSingleton.INSTANCE;
        System.out.println("Inicializando el primer objeto: " + es.hashCode() + " " + es.getInicializacion());
        EnumSingleton es2 = EnumSingleton.INSTANCE;
        System.out.println("Inicializando el segundo objeto: " + es2.hashCode() + " " + es2.getInicializacion());
        System.out.println("");

        ReflectionEnumSingletonTest();
        
        SingletonSerializedTest();
    }

    private static void ReflectionSingletonTest() {
        System.out.println("Reflection Singleton Test...");
        EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceTwo = null;
        try {
            Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();

            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializedSingleton)constructor.newInstance();
                break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Inicializando el primer Objeto: " + instanceOne.hashCode() + " " + instanceOne.getInicializacion());
        System.out.println("Inicializando el Segundo Objeto: " + instanceTwo.hashCode() + " " + instanceTwo.getInicializacion());
        System.out.println("");
    }

    private static void ReflectionEnumSingletonTest() {
        System.out.println("Reflection EnumSingleton Test...");
        EnumSingleton es2 = null;
        try {
            Constructor[] constructors = EnumSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                es2 = (EnumSingleton)constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (es2 != null)
                System.out.println("Refelction EnumSingleton objet: " + es2.hashCode() + " " + es2.getInicializacion());

            System.out.println("");
        }
    }

    private static void SingletonSerializedTest(){
        try{
            //Serialize object to file            
            SerializedSingleton instanceOne = SerializedSingleton.getInstance();
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
            out.writeObject(instanceOne);
            out.close();    
            
            // deserialize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
            SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
            in.close();
            
            System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
            System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());
            System.out.println("");
            
        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    private static void DemoFactory(){
        Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz"); 
        Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");
        System.out.println("Factory PC Config:: " + pc);
        System.out.println("Factory Server Config:: " + server);
        System.out.println("");
    }
    
    private static void DemoAbstractFactory(Integer ram, Integer cores, Integer camera, Integer internalstorage){
        SmartPhone sp = null;
        
        if((cores >= 4 && camera >= 13) && (ram >= 8 && internalstorage >= 32)){
            sp = SmartPhoneFactory.getComputer(new HighEndPhoneFactory(ram.toString(), cores.toString(), camera.toString(), internalstorage.toString()));
        } else if((cores >= 2 &&  camera >= 8) && (ram >= 2 && internalstorage >= 16)){
            sp = SmartPhoneFactory.getComputer(new MidRangePhoneFactory(ram.toString(), cores.toString(), camera.toString(), internalstorage.toString()));
        }else {
            sp = SmartPhoneFactory.getComputer(new LowRangePhoneFactory(ram.toString(), cores.toString(), camera.toString(), internalstorage.toString()));
        }
        
        System.out.println(sp);
        System.out.println("");
    }
    
    private static void DemoBuilderPattern(){
       pkg.desing.patterns.creational.builder.Computer comp = new pkg.desing.patterns.creational.builder.Computer.ComputerBuilder("500 GB", "2 GB").setBluetoothEnabled(false).setGraphicsCardEnabled(true).build();

       System.out.println("RAM: " + comp.getRAM() + ", HDD: " + comp.getHDD() + ", Bluetooth: " + comp.isBluetoothEnabled() + ", GraphicsCard: " + comp.isGraphicsCardEnabled());
       System.out.println("");
    }
    
    private static void DemoPrototypePattern() throws CloneNotSupportedException{
        Employees emps = new Employees();
        emps.loadData();
        
        //Use the clone method to get the Employee object
        Employees empsNew = (Employees)emps.clone();
        Employees empsNew1 =(Employees)emps.clone();
        List list = empsNew.getEmpList();
        list.add("Luis");
        List list1 = empsNew1.getEmpList();
        list1.remove("Horlin");
        
        System.out.println("emps List: " + emps.getEmpList());
        System.out.println("empsNew List: " + empsNew.getEmpList());
        System.out.println("empsNew1 List: " + empsNew1.getEmpList());
        System.out.println("");
    }
}
