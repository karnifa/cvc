package br.com.cvc.infra.mapper;

import br.com.cvc.core.dto.RuleDTO;
import br.com.cvc.infra.entity.RuleEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RuleEntityMapper {

    RuleDTO entityToDTO(RuleEntity entity);

    RuleEntity dtoToEntity(RuleDTO dto);

}
