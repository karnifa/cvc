package br.com.cvc.core.boundary.input.systur;

import br.com.cvc.core.dto.CountryDTO;

import java.util.List;

@FunctionalInterface
public interface FindAllCountriesBoundary {

    List<CountryDTO> execute(String uuid);
}
