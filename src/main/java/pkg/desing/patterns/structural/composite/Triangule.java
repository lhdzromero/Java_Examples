package pkg.desing.patterns.structural.composite;

public class Triangule implements Shape {
    @Override 
    public void draw(String fillColor){
        System.out.println("Drawing Triangle with color " + fillColor);
    }
}
