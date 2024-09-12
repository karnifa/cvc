package br.com.cvc.core.exception;

import br.com.cvc.core.dto.log.LogDTO;
import lombok.Getter;

@Getter // TODO - Felipe - Configurar no handler
public class OrcCorpAuthException extends RuntimeException {

    private LogDTO logDTO;

    public OrcCorpAuthException(LogDTO logDTO) {
        super("Erro ao integrar chamada de login com o orc-springboot-corp-auth.");
        this.logDTO = logDTO;
    }
}
