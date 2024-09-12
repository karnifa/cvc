package br.com.cvc.presentation.mapper.parametertype;

import br.com.cvc.core.dto.ParameterTypeDTO;
import br.com.cvc.presentation.model.parameter.ParameterTypeResponseModel;
import org.mapstruct.Mapper;

@Mapper
public interface ParamaterTypeResponseModelMapper {
    ParameterTypeResponseModel dtoToModel(ParameterTypeDTO parameterTypeDTO);
}
