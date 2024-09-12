package br.com.cvc.infra.mapper;

import br.com.cvc.core.dto.RuleItemDTO;
import br.com.cvc.infra.entity.RuleItemEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RuleItemEntityMapper {

    RuleItemDTO entityToDTO(RuleItemEntity entity);

    RuleItemEntity dtoToEntity(RuleItemDTO dto);
}
