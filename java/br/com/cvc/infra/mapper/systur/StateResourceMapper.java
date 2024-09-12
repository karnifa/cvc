package br.com.cvc.infra.mapper.systur;

import br.com.cvc.core.dto.StateDTO;
import br.com.cvc.infra.resource.systur.StateResource;
import org.mapstruct.Mapper;

@Mapper
public interface StateResourceMapper {

    StateDTO resourceToDTO(StateResource stateResource);
}
