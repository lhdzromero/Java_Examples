package pkg.desing.patterns.structural.composite;

public class Circule implements Shape {
    @Override 
    public void draw(String fillColor){
        System.out.println("Drawing Circule with color " + fillColor);
    }
}
