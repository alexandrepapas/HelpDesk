package com.alexandreHelpDesk.execptions;

import java.io.Serializable;

public class ObjectNotFoundExecpetion extends  RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundExecpetion(String message) {
        super(message);
    }

    public ObjectNotFoundExecpetion(String message, Throwable cause) {
        super(message, cause);
    }
}
