package pkg.desing.patterns.behavior;

import java.util.Scanner;

import pkg.desing.patterns.behavior.chainrespons.ATMDispenseChain;
import pkg.desing.patterns.behavior.chainrespons.Currency;
import pkg.desing.patterns.behavior.command.CloseFileCommand;
import pkg.desing.patterns.behavior.command.FileInvoker;
import pkg.desing.patterns.behavior.command.FileSystemReceiver;
import pkg.desing.patterns.behavior.command.FileSystemReceiverUtil;
import pkg.desing.patterns.behavior.command.OpenFileCommand;
import pkg.desing.patterns.behavior.command.WriteFileCommand;
import pkg.desing.patterns.behavior.interpreter.InterpreterClient;
import pkg.desing.patterns.behavior.interpreter.InterpreterContext;
import pkg.desing.patterns.behavior.iterator.Channel;
import pkg.desing.patterns.behavior.iterator.ChannelCollection;
import pkg.desing.patterns.behavior.iterator.ChannelCollectionImpl;
import pkg.desing.patterns.behavior.iterator.ChannelIterator;
import pkg.desing.patterns.behavior.iterator.ChannelTypeEnum;
import pkg.desing.patterns.behavior.mediator.ChatMediator;
import pkg.desing.patterns.behavior.mediator.ChatMediatorImpl;
import pkg.desing.patterns.behavior.mediator.User;
import pkg.desing.patterns.behavior.mediator.UserImpl;
import pkg.desing.patterns.behavior.memento.FileWriterCaretaker;
import pkg.desing.patterns.behavior.memento.FileWriterUtil;
import pkg.desing.patterns.behavior.template.*;
import pkg.desing.patterns.behavior.visitor.Book;
import pkg.desing.patterns.behavior.visitor.Fruit;
import pkg.desing.patterns.behavior.visitor.ItemElement;
import pkg.desing.patterns.behavior.visitor.ShoppingCartVisitor;
import pkg.desing.patterns.behavior.visitor.ShoppingCartVisitorImpl;
import pkg.desing.patterns.behavior.observer.*;
import pkg.desing.patterns.behavior.state.State;
import pkg.desing.patterns.behavior.state.TVContext;
import pkg.desing.patterns.behavior.state.TVStartState;
import pkg.desing.patterns.behavior.state.TVStopState;
import pkg.desing.patterns.behavior.strategy.CreditCardStrategy;
import pkg.desing.patterns.behavior.strategy.Item;
import pkg.desing.patterns.behavior.strategy.PaypalStrategy;
import pkg.desing.patterns.behavior.strategy.ShoppingCart;
 
public class DemoBehaviorPatterns {
    
    public static void DemoBehaviors(){
        DemoCommandPattern();
        DemoTemplatePattern();
        DemoMediatorPattern();
        DemoObserverPattern();
        DemoStatePattern();
        DemoMementoPattern();
        DemoInterpreterPattern();
        DemoIteratorPattern();
        DemoVisitorPattern();
        DemoStrategyPattern();
        DemoChainResposibilityPattern();
    }
    
    private static void DemoChainResposibilityPattern(){
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        
        System.out.println("\nChain of Resposibility Pattern");
        
        while(true){
            int amount = 0;
            System.out.println("\nEnter amount to dispense: ");
            Scanner input = new Scanner(System.in);
    
            amount = input.nextInt();
            
            if (amount % 10 != 0){
                System.out.println("Amount should be in multiple of 10s");
                return;
            }
            
            atmDispenser.c1.dispense(new Currency(amount));
        }
    }
    
    private static void DemoStrategyPattern(){
        System.out.println("\nStrategy Pattern");
        
        ShoppingCart cart = new ShoppingCart();
    
        Item item1 = new Item("1234", 10);
        Item item2 = new Item("5678", 40);
        
        cart.addItem(item1);
        cart.addItem(item2);
        
        //pay by paypal
        cart.pay(new PaypalStrategy("ainCreditCardStrategy(null, null, null, null)@gmail.com", "pwdsecret"));
       
       //pay by credit card
        cart.pay( new CreditCardStrategy("Aidan Hernandez ", "55012345678901234","123", "11/25"));
    }
    
    private static void DemoVisitorPattern(){
        System.out.println("\nVisitor Pattern");
        ItemElement[] items = new ItemElement[]{
          new Book(20, "1234"),
          new Book(100, "5678"),
          new Fruit(10,2, "Banana"),
          new Fruit(5,5, "Apple"),
        }; 
        
        int total = calculatePrice(items);
        System.out.println("Total Cost = " + total);
    }
    
    private static int calculatePrice(ItemElement[] items){
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        
        int sum = 0;
        for(ItemElement item :items){
            sum += item.accept(visitor);
        }
        
        return sum;
    }
    
    
    private static void DemoCommandPattern(){    
        System.out.println("\nCommand Pattern");
        //Creating the receiver object
        FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();
        
        //Creating command and associating with receiver
        OpenFileCommand openFileCommand = new OpenFileCommand(fs);
        
        //Creating command and associating with command
        FileInvoker file = new FileInvoker(openFileCommand);
        
        //perform action on invoker object
        file.execute();
        
        WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
        file = new FileInvoker(writeFileCommand);
        file.execute();
        
        CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
        file = new FileInvoker(closeFileCommand);
        file.execute();
    }
    
    
    
    
    private static void DemoIteratorPattern(){
        System.out.println("\nIterator Pattern");
        ChannelCollection channels = new ChannelCollectionImpl();
        channels.addChannel(new Channel(98.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(99.5, ChannelTypeEnum.SPANISH));
        channels.addChannel(new Channel(100.5, ChannelTypeEnum.FRENCH));
        channels.addChannel(new Channel(101.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(102.5, ChannelTypeEnum.SPANISH));
        channels.addChannel(new Channel(103.5, ChannelTypeEnum.FRENCH));
        channels.addChannel(new Channel(104.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(105.5, ChannelTypeEnum.SPANISH));
        channels.addChannel(new Channel(106.5, ChannelTypeEnum.FRENCH));
        
        ChannelIterator baseIterator = channels.iterator(ChannelTypeEnum.ALL);
        while(baseIterator.hasNext()){
            Channel c = baseIterator.next();
            System.out.println(c.toString());
        }
        
        System.out.println("*******************************");
        ChannelIterator englishIterator = channels.iterator(ChannelTypeEnum.ENGLISH);
        while(englishIterator.hasNext()){
            Channel c = englishIterator.next();
            System.out.println(c.toString());
        }   
    }
    
    
    private static void DemoInterpreterPattern(){
        System.out.println("\n Interpreter Pattern");
        
        String str1 = "28 in Binary";
        String str2 = "28 in Hexadecimal";
        
        InterpreterClient ec = new InterpreterClient(new InterpreterContext());
        
        System.out.println(str1 + " " + ec.interpret(str1));
        
        System.out.println(str2 + " " + ec.interpret(str2));
        
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
