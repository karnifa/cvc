package br.com.cvc.core.dto.log;

public record PageableDTO(SortDTO sort, int pageNumber, int pageSize, long offset, boolean paged, boolean unpaged) {}
