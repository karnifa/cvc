package br.com.cvc.core.boundary.gateway.systur;

import br.com.cvc.core.dto.AllObjectsDTO;
import br.com.cvc.core.dto.StateDTO;

@FunctionalInterface
public interface FindAllStatesByCountryIdGateway {

    AllObjectsDTO<StateDTO> execute(String countryId, String token, String uuid);
}
