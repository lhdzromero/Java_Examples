
package pkg.demos.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.Optional;

//Librerias para ejecutar javascript
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


import java.util.Base64;
import java.util.UUID;
import java.io.UnsupportedEncodingException;


/*
 * https://www.tutorialspoint.com/java8
 */
public class DemoJava8 {
    
    protected List<String> lstNames1;
    protected List<String> lstNames2;
    protected List<Integer> lstNumbers;
    
    
    public DemoJava8(){
        //Inicializamos la primer lista
        lstNames1 = new ArrayList<String>();
        lstNames1.add("Ignacio");
        lstNames1.add("Aidan");
        lstNames1.add("Aindri");
        lstNames1.add("Constanza");
        lstNames1.add("Leonardo");
        lstNames1.add("Yolanda");
        lstNames1.add("Brenda");
        lstNames1.add("Felipe");
        lstNames1.add("Luis");
        lstNames1.add("Horlin");
        
        //Inicializamos la segunda lista
        lstNames2 = new ArrayList<String>();
        lstNames2.add("Ignacio");
        lstNames2.add("Aindri");
        lstNames2.add("Aidan");
        lstNames2.add("Constanza");
        lstNames2.add("Leonardo");
        lstNames2.add("Yolanda");
        lstNames2.add("Brenda");
        lstNames2.add("Felipe");
        lstNames2.add("Luis");
        lstNames2.add("Horlin"); 
        
        
        //Inicializando lista de enteros
        this.lstNumbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
    }
    
    public void CompareMethods(){        
        System.out.println("Ordenamiento usando la sintaxis de Java 7: ");
        OldSort(this.lstNames1);
        System.out.println(lstNames1);
        System.out.println("");
        
        System.out.println("Ordenamiento usando la sintaxis de Java 8: ");
        NewSort(this.lstNames2);
        System.out.println(lstNames2);
        System.out.println("");
    }
    
    
    public void printList(){
        System.out.println("Imprimiendo cada elemento de la lista...");
        this.lstNames1.forEach(System.out::println);
        System.out.println("");
    }
    
    
    //sort using java 7
    private void OldSort(List<String> names){
        System.out.println("Lista recibida originalmente: ");
        System.out.println(names);
        System.out.println("Ordenando ... ");
        
        Collections.sort(names, new Comparator<String>(){
           @Override
           public int compare(String s1, String s2){
               return s1.compareTo(s2);
           }
        });
    }
    
    //sort using java 8
    private void NewSort(List<String> names){
        System.out.println("Lista recibida originalmente: ");
        System.out.println(names);
        System.out.println("Ordenando ... ");
        
        Collections.sort(names,(s1,s2)-> s1.compareTo(s2));
    }
    

   public void DemoInterfacePredicate(){
       System.out.println("Demo Interface predicate:");
       
       //Predicate<Integer> predicate = n -> true
       //n is passed as parameter to test method of Predicate interface
       //test method will always return true no matter what value n has.
       
       System.out.println("Print all numbers: ");
       //pass n as parameter
       eval(lstNumbers, n -> true);
       
       //Predicate<Integer> predicate1 = n -> n%2 == 0
       //n is passed as parameter to test method of Predicate interface
       //test method will return true if n%2 comes to be a zero
       
       System.out.println("Print even numbers: ");
       eval(lstNumbers, n -> n%2 == 0);
       
       //Predicate<Intger> predicate2 n -> n > 3
       //n is passed as parameter to test method of Predicate interface
       //test method will return  true if n is greater thn 3.
       
       System.out.println("Print number greater than 3");
       eval(lstNumbers, n-> n > 3);    
   } 
   
   public static void eval(List<Integer> lst, Predicate<Integer> predicate){
       for(Integer n : lst){
           if(predicate.test(n)) {
               System.out.println(n + " ");
           }
       }
       System.out.println("");
   }
   
   
   interface MathOperation {
       int operation(int a, int b);
   }
   
   interface GreetingService {
       void sayMessage(String message);
   }
   
   private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
       
   
   public static void LambaExpressions(){
       DemoJava8 tester = new DemoJava8();
       
       System.out.println("\nDemo Lamda Expressions:");
       
       //with type declaration
       MathOperation addition = (int a, int b) -> a + b;
       
       //without type declaration
       MathOperation subtraction = (a, b) -> a - b;
       
       //with return statement along with curly braces
       MathOperation multiplication = (int a, int b) -> { return a * b; };
       
       //without return statement and without curly braces
       MathOperation division = (int a, int b) ->  a/b;
       
       System.out.println("10 + 5 = " + tester.operate(10,5, addition));
       System.out.println("10 - 5 = " + tester.operate(10,5, subtraction));
       System.out.println("10 x 5 = " + tester.operate(10,5, multiplication));
       System.out.println("10 / 5 = " + tester.operate(10,5, division));
       
       //without parenthesis
       GreetingService greetService1 = message -> System.out.println("Hello "  + message);
       
       //without parenthesis
       GreetingService greetService2 = (message) -> System.out.println("Hello " + message);
       
       System.out.println("\nGreetins");
       greetService1.sayMessage("Aidan");
       greetService2.sayMessage("Luis");
       System.out.println("");
   }
   
   public Integer sum(Optional<Integer>a, Optional<Integer> b){
       //Optional.isPresent - checks the value is present or not
       System.out.println("First parameter is present:"  + a.isPresent());
       System.out.println("Second parameter is present:" + b.isPresent());
       
       //Optional.orElse - return the value if present 
       //otherwise returns the default value pased.
       Integer value1 = a.orElse(new Integer(0));
       
       //Optional.get -get the value, value should be present
       Integer value2 = b.get();
       
       return value1 + value2;
   }
   
   
   //Ejecutando javascript desde java 
   public static void DemoJJS(){
       
       System.out.println("\nEjecutando javascript...");
       ScriptEngineManager sem = new ScriptEngineManager();
       ScriptEngine nashorn = sem.getEngineByName("nashorn");
       
       String name = "Aindri";
       Integer result = null;
       
       try{
           nashorn.eval("print('" + name + "')");
           result = (Integer)nashorn.eval(" + 1");
           
       }catch(ScriptException ex){
           System.out.println("Error ejecutando script: " + ex.getMessage());
       }
       
       System.out.println(result.toString());
   }
   
   
   public static void TestEncoder(){
       try {
           //Encode using basic encoder
           String base64encodedString = Base64.getEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
           System.out.println("\nBase64 Encoded String (Basic): " + base64encodedString);
           
           //Decode
           byte[] base64decodeBytes = Base64.getDecoder().decode(base64encodedString);
           System.out.println("Original String: " + new String(base64decodeBytes, "utf-8"));
           
           base64encodedString = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
           System.out.println("Base64 Encoded String (URL) :" + base64encodedString);
           
           StringBuilder sb = new StringBuilder();
           
           for (int i = 0; i < 10; i++)
               sb.append(UUID.randomUUID().toString());
           
           byte[] mimeBytes = sb.toString().getBytes("utf-8");
           String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
           System.out.println("Base64 Encoded String (MIME): " + mimeEncodedString);
           
       } catch (UnsupportedEncodingException e) {
           // TODO: handle exception 
           System.out.println("Error: " + e.getMessage());
        }
   }

}
