package pkg.desing.patterns.creational.abstractfactory;

public class SmartPhoneFactory {
    
    public static SmartPhone getComputer(SmartPhoneAbstractFactory factory){
        return factory.createSmartPhone();
    }
}
