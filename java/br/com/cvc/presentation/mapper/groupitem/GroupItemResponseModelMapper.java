package br.com.cvc.presentation.mapper.groupitem;

import br.com.cvc.core.dto.GroupItemDTO;
import br.com.cvc.presentation.model.groupitem.GroupItemResponseModel;
import org.mapstruct.Mapper;

@Mapper
public interface GroupItemResponseModelMapper {

    GroupItemResponseModel dtoToModel(GroupItemDTO groupItemDTO);
}
