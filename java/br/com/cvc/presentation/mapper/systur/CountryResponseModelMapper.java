package br.com.cvc.presentation.mapper.systur;

import br.com.cvc.core.dto.CountryDTO;
import br.com.cvc.presentation.model.systur.CountryResponseModel;
import org.mapstruct.Mapper;

@Mapper
public interface CountryResponseModelMapper {

    CountryResponseModel dtoToModel(CountryDTO countryDTO);
}
