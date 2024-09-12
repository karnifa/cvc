package br.com.cvc.core.exception;

import br.com.cvc.core.dto.log.LogDTO;
import lombok.Getter;

@Getter // TODO - Felipe - Realizar tratativa no handler com o logDTO
public class FindAllPackageGroupsException extends RuntimeException {

    private final LogDTO logDTO;

    public FindAllPackageGroupsException(LogDTO logDTO) {
        super("Falha ao listar grupos de pacote.");
        this.logDTO = logDTO;
    }
}
