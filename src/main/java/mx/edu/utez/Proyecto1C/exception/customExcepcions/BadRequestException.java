package mx.edu.utez.Proyecto1C.exception.customExcepcions;

public class BadRequestException extends RuntimeException {
    public BadRequestException (String message){
        super(message);
    }
}
