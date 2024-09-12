package br.com.cvc.presentation.mapper.systur;

import br.com.cvc.core.dto.StateDTO;
import br.com.cvc.presentation.model.systur.StateResponseModel;
import org.mapstruct.Mapper;

@Mapper
public interface StateResponseModelMapper {

    StateResponseModel dtoToModel(StateDTO stateDTO);
}
