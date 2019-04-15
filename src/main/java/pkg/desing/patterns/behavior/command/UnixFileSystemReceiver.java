package pkg.desing.patterns.behavior.command;

public class UnixFileSystemReceiver implements FileSystemReceiver {
    @Override
    public void openFile(){
        System.out.println("Opening file in unix OS");
    }
    
    @Override  
    public void writeFile(){
        System.out.println("Writting file in unix OS");
    }
    
    @Override
    public void closeFile(){
       System.out.println("Clossing file in unix OS"); 
    }    
}
