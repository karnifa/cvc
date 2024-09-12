package br.com.cvc.infra.mapper.systur;

import br.com.cvc.core.dto.SystemDTO;
import br.com.cvc.infra.resource.systur.SystemResource;
import org.mapstruct.Mapper;

@Mapper
public interface SystemResourceMapper {

    SystemDTO resourceToDTO(SystemResource systemResource);
}
