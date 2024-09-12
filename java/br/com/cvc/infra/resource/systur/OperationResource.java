package br.com.cvc.infra.resource.systur;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OperationResource(Long id, String name, Long modalityId, String modalityName, Boolean active) {}
