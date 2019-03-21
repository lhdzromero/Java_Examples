package pkg.desing.patterns.structural.composite;

import java.util.List;
import java.util.ArrayList;

public class DrawingShape implements Shape  {
    
    private List<Shape> shapes  = new ArrayList<Shape>();
    
    @Override 
    public void draw(String fillColor){
        for(Shape sh : shapes){
            sh.draw(fillColor);
        }
    }
    
    public void add (Shape s){
        this.shapes.add(s);
    }
    
    public void remove(Shape s){
        this.shapes.remove(s);
    }
    
    public void clear(){
        System.out.println("Cleaning all the shapes from drawing");
        this.shapes.clear();
    }
    
    
}
