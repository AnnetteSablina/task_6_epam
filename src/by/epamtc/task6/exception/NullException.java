package by.epamtc.task6.exception;

public class NullException extends Exception{
    public NullException(String message) {
        super(message);
    }

    public NullException() {
        super();
    }

    public NullException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullException(Throwable cause) {
        super(cause);
    }
}
