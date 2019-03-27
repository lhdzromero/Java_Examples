package pkg.desing.patterns.behavior.observer;

public interface Observer {
    
    //method to update  the observer, used by subject
    public void update();
    
    //attach with subject to observer 
    public void setSubject(Subject sub);
}
