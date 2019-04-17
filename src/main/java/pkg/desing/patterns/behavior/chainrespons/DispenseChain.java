package pkg.desing.patterns.behavior.chainrespons;

public interface DispenseChain {
    
    void setNextChain(DispenseChain nextChain);
    
    void dispense(Currency cur);
    
}
