package br.com.cvc.presentation.handler;

import br.com.cvc.presentation.model.error.ErrorDetails;
import br.com.cvc.presentation.model.error.FieldMessage;
import br.com.cvc.presentation.model.error.ValidationErrorDetails;
import br.com.cvc.core.exception.DuplicatedEntityException;
import br.com.cvc.core.exception.InvalidGroupItemValueException;
import br.com.cvc.core.exception.NotFoundException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Hidden
public class RestExceptionHandler {

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorDetails handleWebExchangeBindException(WebExchangeBindException exception){
        return new ValidationErrorDetails(
            "Erro de validação",
            HttpStatus.BAD_REQUEST.value(),
            "Erro de validação",
            getValidationErrorFields(exception)
        );
    }

    @ExceptionHandler(DuplicatedEntityException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorDetails handleDuplicatedEntityException(DuplicatedEntityException exception){
        return new ErrorDetails(
            "Erro de entidade duplicada",
            HttpStatus.CONFLICT.value(),
            exception.getMessage()
        );
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorDetails handleEntityNotFoundException(NotFoundException exception){
        return new ErrorDetails(
            "Entidade não encontrada",
            HttpStatus.NOT_FOUND.value(),
            exception.getMessage()
        );
    }

    @ExceptionHandler(InvalidGroupItemValueException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public ErrorDetails handle(Exception exception){
        return new ErrorDetails(
                "Não foi possível processar a informação.",
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                exception.getMessage()
        );
    }

    private List<FieldMessage> getValidationErrorFields(WebExchangeBindException exception) {
        return exception.getFieldErrors().stream()
                .map(error -> new FieldMessage(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
    }
}
