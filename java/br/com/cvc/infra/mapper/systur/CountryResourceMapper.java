package br.com.cvc.infra.mapper.systur;

import br.com.cvc.core.dto.CountryDTO;
import br.com.cvc.infra.resource.systur.CountryResource;
import org.mapstruct.Mapper;

@Mapper
public interface CountryResourceMapper {

    CountryDTO resourceToDTO(CountryResource countryResource);
}
