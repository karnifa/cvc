package br.com.cvc.core.dto;

import br.com.cvc.core.dto.log.LogDTO;

public record BranchDTO(Long id, Long code, String name, String location, boolean ownBranch, LogDTO logDTO) {}