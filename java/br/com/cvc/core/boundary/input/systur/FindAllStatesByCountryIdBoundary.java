package br.com.cvc.core.boundary.input.systur;

import br.com.cvc.core.dto.StateDTO;

import java.util.List;

@FunctionalInterface
public interface FindAllStatesByCountryIdBoundary {

    List<StateDTO> execute(String countryId, String uuid);
}
