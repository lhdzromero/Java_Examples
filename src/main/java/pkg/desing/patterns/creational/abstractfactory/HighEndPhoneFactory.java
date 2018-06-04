package pkg.desing.patterns.creational.abstractfactory;

public class HighEndPhoneFactory implements SmartPhoneAbstractFactory {
    private String gama;
    private String ram;
    private String cores;
    private String camera;
    private String internalstorage;
    
    public HighEndPhoneFactory(String ram, String cores, String camera, String internalstorage){
        this.gama = "HighEndPhone";
        this.ram = ram;
        this.cores = cores;
        this.camera = camera;
        this.internalstorage = internalstorage;
    }
    
    @Override
    public SmartPhone createSmartPhone(){
        return new HighEndPhone(gama, ram, cores, camera, internalstorage);
    }
    
}
