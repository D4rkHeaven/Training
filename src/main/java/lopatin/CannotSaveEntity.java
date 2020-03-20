package lopatin;

/**
 * Unchecked exception
 */
public class CannotSaveEntity extends RuntimeException {
    public CannotSaveEntity(String message) {
        super(message);
    }
}
