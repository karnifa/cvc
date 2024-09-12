package br.com.cvc.core.boundary.gateway.systur;

import br.com.cvc.core.dto.AllObjectsDTO;
import br.com.cvc.core.dto.CityDTO;

@FunctionalInterface
public interface FindAllCitiesByCountryIdAndStateIdGateway {

    AllObjectsDTO<CityDTO> execute(String countryId, String state, String token, String uuid);
}
