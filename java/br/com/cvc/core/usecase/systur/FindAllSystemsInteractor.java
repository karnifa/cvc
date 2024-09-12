package br.com.cvc.core.usecase.systur;

import br.com.cvc.core.boundary.gateway.corpauth.AuthorizeUserApplicationInCorpAuthGateway;
import br.com.cvc.core.boundary.gateway.systur.FindAllSystemsGateway;
import br.com.cvc.core.boundary.input.systur.FindAllSystemsBoundary;
import br.com.cvc.core.dto.SystemDTO;
import br.com.cvc.core.dto.corpauth.OrcCorpAuthLoginRequestDTO;
import br.com.cvc.core.util.ClientApps;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllSystemsInteractor implements FindAllSystemsBoundary {

    private final AuthorizeUserApplicationInCorpAuthGateway authorizeUserApplicationInCorpAuthGateway;
    private final FindAllSystemsGateway findAllSystemsGateway;

    @Override
    public List<SystemDTO> execute(String uuid) {
        final var orcCorpAuthLoginResponseDTO = this.authorizeUserApplicationInCorpAuthGateway.execute(new OrcCorpAuthLoginRequestDTO(uuid, ClientApps.ACL_SPRINGBOOT_PAYMENT_METHODS));
        final var allObjects = this.findAllSystemsGateway.execute(orcCorpAuthLoginResponseDTO.accessToken(), uuid);
        return allObjects.data();
    }
}
