package lopatin;

/* Проверяемое исключение */
public class EntityNotFound extends Exception{
    public EntityNotFound(String message){
        super(message);
    }

}
