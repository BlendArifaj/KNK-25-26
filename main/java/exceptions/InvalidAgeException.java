package exceptions;

public class InvalidAgeException extends Exception{
    public InvalidAgeException(int age){
        super("Age: " + age + " is not allowed!");
    }
}
