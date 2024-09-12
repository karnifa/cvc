package br.com.cvc.core.dto;

import br.com.cvc.core.dto.log.LogDTO;

import java.util.List;

public record AllObjectsDTO<T>(List<T> data, LogDTO logDTO) {}
