package by.epamtc.task6.exception;

import java.io.IOException;

public class ClassNotFoundException extends IOException {
    public ClassNotFoundException(String message) {
        super(message);
    }

    public ClassNotFoundException() {
        super();
    }

    public ClassNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClassNotFoundException(Throwable cause) {
        super(cause);
    }
}
