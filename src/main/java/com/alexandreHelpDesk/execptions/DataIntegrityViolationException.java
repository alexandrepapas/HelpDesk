package com.alexandreHelpDesk.execptions;

import java.io.Serializable;

public class DataIntegrityViolationException extends  RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public DataIntegrityViolationException(String message) {
        super(message);
    }

    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
