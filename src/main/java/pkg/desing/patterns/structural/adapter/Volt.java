package pkg.desing.patterns.structural.adapter;

public class Volt {
    private int volts;
    
    public Volt(int v){
        this.volts = v;
    }
    
    public int getVolts(){
        return volts;
    }
    
    public void setVolts(int v){
        this.volts = v;
    }
}
