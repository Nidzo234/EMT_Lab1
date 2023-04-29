package ukim.finki.lab1.model.Exception;

public class InvalidIdException extends RuntimeException{
    public InvalidIdException() {
        super("Invalid Id");
    }
}
