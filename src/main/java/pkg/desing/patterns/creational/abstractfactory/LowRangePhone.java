package pkg.desing.patterns.creational.abstractfactory;

public class LowRangePhone extends SmartPhone {
    private String gama;
    private String ram;
    private String cores;
    private String camera;
    private String internalstorage;
    
    public LowRangePhone(String gama, String ram, String cores, String camera, String internalstorage){
        this.gama = gama;
        this.ram = ram;
        this.cores = cores;
        this.camera = camera;
        this.internalstorage = internalstorage;
    }
    
    
    @Override
    public String getGama(){
        return this.gama;
    }
    
    @Override
    public String getRAM(){
        return this.ram;
    }
    
    @Override
    public String getCores(){
        return this.cores;
    }
    
    @Override
    public String getCamera(){
        return this.camera;
    }
    
    @Override
    public String getInternalStorage(){
        return this.internalstorage;
    }
}
