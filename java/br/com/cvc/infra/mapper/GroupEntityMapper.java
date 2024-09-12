package br.com.cvc.infra.mapper;

import br.com.cvc.core.dto.GroupDTO;
import br.com.cvc.infra.entity.GroupEntity;
import org.mapstruct.Mapper;

@Mapper
public interface GroupEntityMapper {

    GroupDTO entityToDTO(GroupEntity entity);

    GroupEntity dtoToEntity(GroupDTO dto);

}
