package lopatin;

/* Непроверяемое исключение */
public class CannotSaveEntity extends RuntimeException {
    public CannotSaveEntity (String message){
        super(message);
    }
}
