package br.com.cvc.infra.mapper;

import br.com.cvc.core.dto.GroupItemDTO;
import br.com.cvc.infra.entity.GroupItemEntity;
import org.mapstruct.Mapper;

@Mapper
public interface GroupItemEntityMapper {

    GroupItemDTO entityToDTO(GroupItemEntity entity);

    GroupItemEntity dtoToEntity(GroupItemDTO dto);
}
