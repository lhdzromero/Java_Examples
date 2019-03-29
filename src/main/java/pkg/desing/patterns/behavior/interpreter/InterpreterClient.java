package pkg.desing.patterns.behavior.interpreter;

public class InterpreterClient {
    public InterpreterContext ic;
    
    public InterpreterClient(InterpreterContext i){
        this.ic = i;
    }
    
    public String interpret(String str){
        Expression exp = null;
        
        //create rules for expresssions 
        if(str.contains("Hexadecimal")){
            exp = new IntToHexExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
        }else if(str.contains("Binary")){
            exp  = new IntToBinaryExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
        }else  return str;
        
        return exp.interpreter(ic);    
    }
}
