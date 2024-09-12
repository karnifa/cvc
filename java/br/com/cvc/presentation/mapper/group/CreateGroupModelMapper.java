package br.com.cvc.presentation.mapper.group;

import br.com.cvc.core.dto.GroupDTO;
import br.com.cvc.presentation.model.group.GroupRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CreateGroupModelMapper {

    @Mapping(target = "parameterType.id", source = "groupRequestModel.parameterTypeId")
    GroupDTO modelToDTO(GroupRequestModel groupRequestModel, Long id);
}
