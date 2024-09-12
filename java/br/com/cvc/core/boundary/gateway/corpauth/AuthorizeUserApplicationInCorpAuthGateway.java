package br.com.cvc.core.boundary.gateway.corpauth;

import br.com.cvc.core.dto.corpauth.OrcCorpAuthLoginRequestDTO;
import br.com.cvc.core.dto.corpauth.OrcCorpAuthLoginResponseDTO;

@FunctionalInterface
public interface AuthorizeUserApplicationInCorpAuthGateway {

    OrcCorpAuthLoginResponseDTO execute(OrcCorpAuthLoginRequestDTO orcCorpAuthLoginRequestDTO);
}
