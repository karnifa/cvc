package br.com.cvc.core.dto.log;

public record RequestDTO(String method, String url, String headers, String body) {}
