package pkg.desing.patterns.structural.facade;

//Facade Class
public class ShapeMaker {
    private Shape circule;
    private Shape rectangule;
    private Shape square;
    
    public ShapeMaker(){
        circule = new Circle();
        rectangule = new Rectangule();
        square = new Square();
    }
    
    
    public void drawShape(int opc){
        switch(opc){
        case 1:
            drawCircule();
        break;
        case 2:
            drawRectangule();
        break;
        case 3:
            drawSquare();
        break;
        }
    }
        
    private void drawCircule(){
        circule.draw();
    }
    
    private void drawRectangule(){
        rectangule.draw();
    }
    
    private void drawSquare(){
        square.draw();
    }
}
