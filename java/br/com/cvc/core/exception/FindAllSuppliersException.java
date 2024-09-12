package br.com.cvc.core.exception;

import br.com.cvc.core.dto.log.LogDTO;
import lombok.Getter;

@Getter // TODO - Felipe - Realizar tratativa no handler com o logDTO
public class FindAllSuppliersException extends RuntimeException {

    private final LogDTO logDTO;

    public FindAllSuppliersException(LogDTO logDTO) {
        super("Falha ao listar fornecedores.");
        this.logDTO = logDTO;
    }
}
