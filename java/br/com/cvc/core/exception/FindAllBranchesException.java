package br.com.cvc.core.exception;

import br.com.cvc.core.dto.log.LogDTO;
import lombok.Getter;

// TODO - Felipe - Realizar tratativa no handler com o logDTO
@Getter
public class FindAllBranchesException extends RuntimeException {

    private final LogDTO logDTO;

    public FindAllBranchesException(LogDTO logDTO) {
        super("Falha ao listar filiais.");
        this.logDTO = logDTO;
    }
}
