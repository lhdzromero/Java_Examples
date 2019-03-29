package pkg.desing.patterns.behavior.interpreter;

public class IntToHexExpression implements Expression {
    private int i;
    
    public IntToHexExpression(int c){
        this.i = c;
    }
    
    @Override
    public String interpreter(InterpreterContext ic){
        return ic.getHexadecimalFormat(this.i);
    }
}
