package pkg.desing.patterns.creational.abstractfactory;

public abstract class SmartPhone {
    public abstract String getRAM();
    public abstract String getCores();
    public abstract String getCamera();
    public abstract String getInternalStorage();
    public abstract String getGama();
    
    @Override
    public String toString(){
        return this.getGama() + ":: RAM = " + this.getRAM() + ", Cores = " + this.getCores() + ", Camera = " + this.getCamera() + ", Internal Storage = " + this.getInternalStorage();
    }
}
