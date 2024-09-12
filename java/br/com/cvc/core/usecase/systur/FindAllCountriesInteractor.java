package br.com.cvc.core.usecase.systur;

import br.com.cvc.core.boundary.gateway.corpauth.AuthorizeUserApplicationInCorpAuthGateway;
import br.com.cvc.core.boundary.gateway.systur.FindAllCountriesGateway;
import br.com.cvc.core.boundary.input.systur.FindAllCountriesBoundary;
import br.com.cvc.core.dto.CountryDTO;
import br.com.cvc.core.dto.corpauth.OrcCorpAuthLoginRequestDTO;
import br.com.cvc.core.util.ClientApps;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllCountriesInteractor implements FindAllCountriesBoundary {

    private final AuthorizeUserApplicationInCorpAuthGateway authorizeUserApplicationInCorpAuthGateway;
    private final FindAllCountriesGateway findAllCountriesGateway;

    @Override
    public List<CountryDTO> execute(String uuid) {
        final var orcCorpAuthLoginResponseDTO = this.authorizeUserApplicationInCorpAuthGateway.execute(new OrcCorpAuthLoginRequestDTO(uuid, ClientApps.ACL_SPRINGBOOT_PAYMENT_METHODS));
        final var allObjects = this.findAllCountriesGateway.execute(orcCorpAuthLoginResponseDTO.accessToken(), uuid);
        return allObjects.data();
    }
}
