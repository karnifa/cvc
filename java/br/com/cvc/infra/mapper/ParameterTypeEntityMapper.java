package br.com.cvc.infra.mapper;

import br.com.cvc.core.dto.ParameterTypeDTO;
import br.com.cvc.infra.entity.ParameterTypeEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ParameterTypeEntityMapper {
    ParameterTypeDTO entityToDTO(ParameterTypeEntity entity);
}
