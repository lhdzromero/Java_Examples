package pkg.desing.patterns.behavior.chainrespons;

public class ATMDispenseChain {
    public DispenseChain c1;
    
    public ATMDispenseChain(){
        //initialize chain
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();
        
        //Set the chain of responsability
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }
}
