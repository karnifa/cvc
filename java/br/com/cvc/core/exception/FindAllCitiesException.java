package br.com.cvc.core.exception;

import br.com.cvc.core.dto.log.LogDTO;
import lombok.Getter;

// TODO - Felipe - Realizar tratativa no handler com o logDTO
@Getter
public class FindAllCitiesException extends RuntimeException {

    private final LogDTO logDTO;

    public FindAllCitiesException(LogDTO logDTO) {
        super("Falha ao listar cidades.");
        this.logDTO = logDTO;
    }
}
