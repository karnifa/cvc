package br.com.cvc.core.dto;

public record OperationDTO(Long id, String name, Long modalityId, String modalityName, Boolean active) {}
