package pkg.desing.patterns.behavior.interpreter;

public class IntToBinaryExpression implements Expression {
    private int i;
    
    public  IntToBinaryExpression(int c){
        this.i = c;
    }
    
    @Override 
    public String interpreter(InterpreterContext ic){
        return ic.getBinaryFormat(this.i);
    }
}
