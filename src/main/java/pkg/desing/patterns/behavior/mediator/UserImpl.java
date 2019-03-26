package pkg.desing.patterns.behavior.mediator;

public class UserImpl extends User {
    
    public UserImpl(ChatMediator med, String name){
        super(med, name);
    }
    
    @Override
    public void send(String msg){
        System.out.println(this.name + ": Sending Message = " + msg);
        mediator.sendMessage(msg, this);
    }
    
    @Override 
    public void recive(String msg){
        System.out.println(this.name + " : Recived Message: " + msg);
    }
}
