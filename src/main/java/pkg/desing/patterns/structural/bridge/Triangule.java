package pkg.desing.patterns.structural.bridge;

public class Triangule extends Shape {
    
    public Triangule(Color c){
        super(c);
    }
    
    @Override 
    public void applyColor(){
        System.out.print("\nTriangule filled with color ");
        color.applyColor();
    }
    
}
