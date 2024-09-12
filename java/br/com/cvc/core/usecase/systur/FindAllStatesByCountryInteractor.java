package br.com.cvc.core.usecase.systur;

import br.com.cvc.core.boundary.gateway.corpauth.AuthorizeUserApplicationInCorpAuthGateway;
import br.com.cvc.core.boundary.gateway.systur.FindAllStatesByCountryIdGateway;
import br.com.cvc.core.boundary.input.systur.FindAllStatesByCountryIdBoundary;
import br.com.cvc.core.dto.StateDTO;
import br.com.cvc.core.dto.corpauth.OrcCorpAuthLoginRequestDTO;
import br.com.cvc.core.util.ClientApps;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllStatesByCountryInteractor implements FindAllStatesByCountryIdBoundary {

    private final AuthorizeUserApplicationInCorpAuthGateway authorizeUserApplicationInCorpAuthGateway;
    private final FindAllStatesByCountryIdGateway findAllStatesByCountryIdGateway;
    @Override
    public List<StateDTO> execute(String countryId, String uuid) {
        final var orcCorpAuthLoginResponseDTO = this.authorizeUserApplicationInCorpAuthGateway.execute(new OrcCorpAuthLoginRequestDTO(uuid, ClientApps.ACL_SPRINGBOOT_PAYMENT_METHODS));
        final var allObjects = this.findAllStatesByCountryIdGateway.execute(countryId, orcCorpAuthLoginResponseDTO.accessToken(), uuid);
        return allObjects.data();
    }
}
