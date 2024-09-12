package br.com.cvc.infra.resource.systur;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BranchResource(Long id, Long code, String name, String location, boolean ownBranch) {}