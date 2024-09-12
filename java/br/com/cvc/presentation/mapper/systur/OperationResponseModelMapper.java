package br.com.cvc.presentation.mapper.systur;

import br.com.cvc.core.dto.OperationDTO;
import br.com.cvc.presentation.model.systur.OperationResponseModel;
import org.mapstruct.Mapper;

@Mapper
public interface OperationResponseModelMapper {

    OperationResponseModel dtoToModel(OperationDTO operationDTO);
}
