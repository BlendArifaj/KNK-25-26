package exceptions;

public class InvalidNameException extends Exception{
    public InvalidNameException(String name){
        super(name + " is not valid!");
    }
}
