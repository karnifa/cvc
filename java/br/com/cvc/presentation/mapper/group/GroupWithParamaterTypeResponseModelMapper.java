package br.com.cvc.presentation.mapper.group;

import br.com.cvc.core.dto.GroupDTO;
import br.com.cvc.core.dto.pagination.ListDTO;
import br.com.cvc.presentation.model.group.GroupWithParameterTypeResponseModel;
import org.mapstruct.Mapper;

@Mapper
public interface GroupWithParamaterTypeResponseModelMapper {

    ListDTO<GroupWithParameterTypeResponseModel> dtoToModel(ListDTO<GroupDTO> groupDTOs);

    GroupWithParameterTypeResponseModel dtoToModel(GroupDTO groupDTO);
}
