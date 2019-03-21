package pkg.desing.patterns.structural.bridge;

public class Pentagon extends Shape {
    public Pentagon (Color c){
        super(c);
    }
    
    @Override 
    public void applyColor(){
        System.out.print("\nPentagon filled with color ");
        color.applyColor();
    }
}
