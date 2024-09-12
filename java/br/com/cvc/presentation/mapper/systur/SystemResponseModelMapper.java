package br.com.cvc.presentation.mapper.systur;

import br.com.cvc.core.dto.SystemDTO;
import br.com.cvc.presentation.model.systur.SystemResponseModel;
import org.mapstruct.Mapper;

@Mapper
public interface SystemResponseModelMapper {

    SystemResponseModel dtoToModel(SystemDTO systemDTO);
}
