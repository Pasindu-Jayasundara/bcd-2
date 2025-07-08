package org.example.ee.core.exception;

import jakarta.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class InvalidParameterException extends RuntimeException{

    public InvalidParameterException(String s) {
        super(s);
    }
}
