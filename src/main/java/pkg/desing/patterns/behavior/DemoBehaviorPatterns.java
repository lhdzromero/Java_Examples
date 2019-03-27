package pkg.desing.patterns.behavior;

import pkg.desing.patterns.behavior.mediator.ChatMediator;
import pkg.desing.patterns.behavior.mediator.ChatMediatorImpl;
import pkg.desing.patterns.behavior.mediator.User;
import pkg.desing.patterns.behavior.mediator.UserImpl;
import pkg.desing.patterns.behavior.template.*;
import pkg.desing.patterns.behavior.template.HouseTemplate;
import pkg.desing.patterns.behavior.observer.*;

 
public class DemoBehaviorPatterns {
    
    public static void DemoBehaviors(){
        DemoTemplatePattern();
        DemoMediatorPattern();
        DemoObserverPattern();
    }
    
    
    private static void DemoObserverPattern(){
        System.out.println("\nObserver Pattern...");
        
        //Create subject
        MyTopic topic = new MyTopic();
        
        //Create observers
        Observer obj1 = new MyTopicSubscriber("Obj1");
        Observer obj2 = new MyTopicSubscriber("Obj2");
        Observer obj3 = new MyTopicSubscriber("Obj3");
        
        //register observers to the subject
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);
        
        //attach observer to subject 
        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);
        
        //check if any update is available
        obj1.update();
        
        //now send message to subject
        topic.postMessage("New Message");
        
    }
    
    private static void DemoMediatorPattern(){
         System.out.println("\nMediator Pattern...");
         ChatMediator mediator = new ChatMediatorImpl();
         
         User user1 = new UserImpl(mediator, "Aindri");
         User user2 = new UserImpl(mediator, "Aidan");
         User user3 = new UserImpl(mediator, "Horlin");
         User user4 = new UserImpl(mediator, "Luis");
         mediator.addUser(user1);
         mediator.addUser(user2);
         mediator.addUser(user3);
         mediator.addUser(user4);
         
         user1.send("Hi All");
         System.out.println("**************************************");
         user2.send(" Hello Aindri");
    }
    
    private static void DemoTemplatePattern(){
        System.out.println("\nTemplate Pattern...");
        
        HouseTemplate houseType = new WoodenHouse();
        //using template method
        houseType.buildHouse();
        
        for (int i = 0; i < 21; i++)
            System.out.print("*");
            
        System.out.println("");
        houseType = new GlassHouse();
        houseType.buildHouse();
    }
}
