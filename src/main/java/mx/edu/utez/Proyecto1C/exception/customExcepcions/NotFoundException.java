package mx.edu.utez.Proyecto1C.exception.customExcepcions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
