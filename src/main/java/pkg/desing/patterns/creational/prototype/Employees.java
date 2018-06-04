package pkg.desing.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Employees implements Cloneable {
    private List empList;
    
    public Employees(){
        empList = new ArrayList();
    }
    
    public Employees(List list){
        this.empList = list;
    }
    
    public void loadData(){
        empList.add("Aidan");
        empList.add("Aindri");
        empList.add("Gloria");
        empList.add("Horlin");
    }
    
    public List getEmpList(){
        return empList;
    }
    
    @Override
    public Object clone () throws CloneNotSupportedException{
        List temp = new ArrayList();
        
        for (Object object : this.getEmpList()) {
            temp.add((String)object);    
        }
        
        return new Employees(temp);
    }
    
    
}
