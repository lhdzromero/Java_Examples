package pkg.desing.patterns.creational.abstractfactory;

public class LowRangePhoneFactory implements SmartPhoneAbstractFactory {
    private String gama;
    private String ram;
    private String cores;
    private String camera;
    private String internalstorage;
    
    public LowRangePhoneFactory(String ram, String cores, String camera, String internalstorage){
        this.gama = "LowRangePhone";
        this.ram = ram;
        this.cores = cores;
        this.camera = camera;
        this.internalstorage = internalstorage;
    }
    
    @Override
    public SmartPhone createSmartPhone(){
        return new LowRangePhone(gama, ram, cores, camera, internalstorage);
    }
    
}
