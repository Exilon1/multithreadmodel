package exceptions;

/**
 * Created by Alexey on 28.11.2016.
 */
public class NotValidAdressException extends Exception {

    @Override
    public String getMessage() {
        return "Adress form isn't correct.";
    }
}
