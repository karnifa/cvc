package br.com.cvc.core.boundary.gateway.systur;

import br.com.cvc.core.dto.AllObjectsDTO;
import br.com.cvc.core.dto.CountryDTO;

@FunctionalInterface
public interface FindAllCountriesGateway {

    AllObjectsDTO<CountryDTO> execute(String token, String uuid);
}
