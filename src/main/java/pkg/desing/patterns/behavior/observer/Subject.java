package pkg.desing.patterns.behavior.observer;

public interface Subject {
    public void register(Observer obj);
    public void unregister(Observer obj);
    
    //method to notify observers of change
    public void notifyObservers();
    
    //method to get updates form subject
    public Object getUpdate(Observer obj);
}
