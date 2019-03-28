package pkg.desing.patterns.behavior;

import pkg.desing.patterns.behavior.mediator.ChatMediator;
import pkg.desing.patterns.behavior.mediator.ChatMediatorImpl;
import pkg.desing.patterns.behavior.mediator.User;
import pkg.desing.patterns.behavior.mediator.UserImpl;
import pkg.desing.patterns.behavior.memento.FileWriterCaretaker;
import pkg.desing.patterns.behavior.memento.FileWriterUtil;
import pkg.desing.patterns.behavior.template.*;
import pkg.desing.patterns.behavior.observer.*;
import pkg.desing.patterns.behavior.state.State;
import pkg.desing.patterns.behavior.state.TVContext;
import pkg.desing.patterns.behavior.state.TVStartState;
import pkg.desing.patterns.behavior.state.TVStopState;
 
public class DemoBehaviorPatterns {
    
    public static void DemoBehaviors(){
        DemoTemplatePattern();
        DemoMediatorPattern();
        DemoObserverPattern();
        DemoStatePattern();
        DemoMementoPattern();
    }
    
    
    private static void DemoMementoPattern(){
        System.out.println("\nMemento Pattern...");
        
        FileWriterCaretaker caretaker = new FileWriterCaretaker();
        
        FileWriterUtil fileWriter = new FileWriterUtil("data.txt");
        fileWriter.write("First Set of Data\n");
        System.out.println(fileWriter + "\n\n");
        
        //lets save the file
        caretaker.save(fileWriter);
        
        //now write something else
        fileWriter.write("Second Set of Data\n");
        //checking file contents
        System.out.println(fileWriter + "\n\n");
        
        //lets undo to last save
        caretaker.undo(fileWriter);
        
        //checking file content again
        System.out.println(fileWriter + "\n\n");
        
        
        fileWriter.write("Third Set of Data\n");
        System.out.println(fileWriter + "\n\n");
        
        caretaker.save(fileWriter);
        
        fileWriter.write("Fourth Set of Data\n");
        System.out.println(fileWriter + "\n\n");
        
        caretaker.undo(fileWriter);
        System.out.println(fileWriter + "\n\n");        
    }
    
    
    private static void DemoStatePattern(){
        System.out.println("\nState Pattern...");
        
        TVContext context = new TVContext();
        State tvStartState = new TVStartState();
        State tvStopState = new TVStopState();
        
        context.setState(tvStartState);
        context.doAction();
        
        context.setState(tvStopState);
        context.doAction();
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
