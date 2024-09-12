package br.com.cvc.core.usecase.systur;

import br.com.cvc.core.boundary.gateway.corpauth.AuthorizeUserApplicationInCorpAuthGateway;
import br.com.cvc.core.boundary.gateway.systur.FindAllCitiesByCountryIdAndStateIdGateway;
import br.com.cvc.core.boundary.input.systur.FindAllCitiesByCountryIdAndStateIdBoundary;
import br.com.cvc.core.dto.CityDTO;
import br.com.cvc.core.dto.corpauth.OrcCorpAuthLoginRequestDTO;
import br.com.cvc.core.util.ClientApps;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllCitiesByCountryIdAndStateIdInteractor implements FindAllCitiesByCountryIdAndStateIdBoundary {

    private final AuthorizeUserApplicationInCorpAuthGateway authorizeUserApplicationInCorpAuthGateway;
    private final FindAllCitiesByCountryIdAndStateIdGateway findAllCitiesByCountryIdAndStateIdGateway;

    @Override
    public List<CityDTO> execute(String countryId, String state, String uuid) {
        final var orcCorpAuthLoginResponseDTO = this.authorizeUserApplicationInCorpAuthGateway.execute(new OrcCorpAuthLoginRequestDTO(uuid, ClientApps.ACL_SPRINGBOOT_PAYMENT_METHODS));
        final var allObjects = this.findAllCitiesByCountryIdAndStateIdGateway.execute(countryId, state, orcCorpAuthLoginResponseDTO.accessToken(), uuid);
        return allObjects.data();
    }
}
