package br.com.cvc.core.exception;

public class FindByParamsException extends RuntimeException {
    public FindByParamsException() {
        super("Informe ao menos um parâmetro para filtragem.");
    }
}
