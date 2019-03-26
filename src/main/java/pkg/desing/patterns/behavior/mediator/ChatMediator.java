package pkg.desing.patterns.behavior.mediator;

public interface ChatMediator {
    public void sendMessage(String msg, User user);
    
    void addUser(User user);
}
