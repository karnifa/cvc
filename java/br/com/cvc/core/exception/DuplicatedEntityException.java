package br.com.cvc.core.exception;

public class DuplicatedEntityException extends RuntimeException {
    public DuplicatedEntityException(final String message) {
        super(message);
    }
}
