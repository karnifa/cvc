package br.com.cvc.infra.mapper.systur;

import br.com.cvc.core.dto.OperationDTO;
import br.com.cvc.infra.resource.systur.OperationResource;
import org.mapstruct.Mapper;

@Mapper
public interface OperationResourceMapper {

    OperationDTO resourceToDTO(OperationResource operationResource);
}
