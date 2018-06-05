package pkg.demos.examples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import pkg.desing.patterns.*;

/*
 * https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
 */

public class App {
    
    public static void main(String args []) throws FileNotFoundException, IOException, ClassNotFoundException {
       DemosPatterns.DemosRun();
        
        HackInmutable.InmutableEmployee emp = new  HackInmutable.InmutableEmployee(1,"John Doe", 100f);
        System.out.printf("The salary of %1$s is %2$s bitcoins. Salary should be hidden: /\n", emp.name(), HackInmutable.giveMe(emp,"salary"));
        HackInmutable.hackIt(emp, "salary", 600f);
        HackInmutable.hackIt(emp, "name", "Walter Smith");
        System.out.printf("The salary of %1$s now is %2$s bitcoins. WTF \n", emp.name(), HackInmutable.giveMe(emp,"salary"));
        System.out.println("");
       
        DemoJava8 demo = new DemoJava8();
        demo.CompareMethods();
        demo.printList();
        demo.DemoInterfacePredicate();
        demo.LambaExpressions();
        
        Integer value1 = null;
        Integer value2 = new Integer(10);
        
        //Optional.ofNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.ofNullable(value1);
        
        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);
        System.out.println(demo.sum(a, b));
        
        demo.DemoJJS();
        demo.TestEncoder();
        
        /*DemoStreamsJava8 dsj = new DemoStreamsJava8();
        dsj.StreamJava7();
        dsj.StreamJava8();
        
    
        Vehicle vehicle = new Car();
        vehicle.print();
        
        DemoReadXML.ReadXMLSAX("employees.xml");
        DemoReadXML.ReadXMLDOM("DomExample.xml");
        DemoReadXML.ReadXMLLoop("DomExample.xml");
        */
    }
}
