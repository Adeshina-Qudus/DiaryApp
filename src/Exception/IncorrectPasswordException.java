package Exception;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(String incorrectPassword) {
        super(incorrectPassword);
    }
}
