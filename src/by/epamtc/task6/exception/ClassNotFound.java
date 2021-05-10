package by.epamtc.task6.exception;

import java.io.IOException;

public class ClassNotFound extends IOException {
    public ClassNotFound(String message) {
        super(message);
    }

    public ClassNotFound() {
        super();
    }

    public ClassNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ClassNotFound(Throwable cause) {
        super(cause);
    }
}
