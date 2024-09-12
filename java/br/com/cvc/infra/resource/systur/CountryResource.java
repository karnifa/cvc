package br.com.cvc.infra.resource.systur;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CountryResource(String id, String name) {}
