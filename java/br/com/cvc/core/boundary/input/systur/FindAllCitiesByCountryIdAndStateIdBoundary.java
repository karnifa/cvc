package br.com.cvc.core.boundary.input.systur;

import br.com.cvc.core.dto.CityDTO;

import java.util.List;

@FunctionalInterface
public interface FindAllCitiesByCountryIdAndStateIdBoundary {

    List<CityDTO> execute(String countryId, String state, String uuid);
}
