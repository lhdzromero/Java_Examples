package pkg.desing.patterns.creational.abstractfactory;

public class MidRangePhoneFactory implements SmartPhoneAbstractFactory {
    private String gama;
    private String ram;
    private String cores;
    private String camera;
    private String internalstorage;
    
    public MidRangePhoneFactory(String ram, String cores, String camera, String internalstorage){
        this.gama = "MidRangePhone";
        this.ram = ram;
        this.cores = cores;
        this.camera = camera;
        this.internalstorage = internalstorage;
    }
    
    @Override
    public SmartPhone createSmartPhone(){
        return new MidRangePhone(gama, ram,cores,camera,internalstorage);
    } 
    
}
