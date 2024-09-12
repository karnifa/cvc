package br.com.cvc.presentation.model.error;

import java.util.List;

public record ValidationErrorDetails(String title, int status, String detail, List<FieldMessage> validationErrors){}
