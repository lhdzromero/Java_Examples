package pkg.desing.patterns.creational.factory;

public class ComputerFactory {
    public static Computer getComputer(String type, String ram, String hdd, String cpu){
        switch(type.toUpperCase()){
            case "PC":
                return new PC(ram, hdd, cpu);
            case "SERVER":
                return new Server(ram, hdd, cpu);
            default:
                return null;
        }
    }
}
