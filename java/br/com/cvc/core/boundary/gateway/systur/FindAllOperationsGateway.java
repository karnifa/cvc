package br.com.cvc.core.boundary.gateway.systur;

import br.com.cvc.core.dto.AllObjectsDTO;
import br.com.cvc.core.dto.OperationDTO;

@FunctionalInterface
public interface FindAllOperationsGateway {

    AllObjectsDTO<OperationDTO> execute(String token, String uuid);
}
