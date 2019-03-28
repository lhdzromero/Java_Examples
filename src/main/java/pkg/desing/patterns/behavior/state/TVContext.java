package pkg.desing.patterns.behavior.state;

public class TVContext implements State {
    private State tvState;
    
    public void setState(State state){
        this.tvState = state;
    }
    
    public State getSate(){
        return this.tvState;
    }
    
    @Override
    public void doAction(){
        this.tvState.doAction();
    }
    
}
