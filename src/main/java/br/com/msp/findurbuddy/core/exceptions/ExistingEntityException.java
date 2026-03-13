package br.com.msp.findurbuddy.core.exceptions;

public class ExistingEntityException extends RuntimeException {
    public ExistingEntityException(String message) {
        super(message);
    }
}
