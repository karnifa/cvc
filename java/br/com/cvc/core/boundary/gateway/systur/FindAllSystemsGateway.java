package br.com.cvc.core.boundary.gateway.systur;

import br.com.cvc.core.dto.AllObjectsDTO;
import br.com.cvc.core.dto.SystemDTO;

@FunctionalInterface
public interface FindAllSystemsGateway {

    AllObjectsDTO<SystemDTO> execute(String token, String uuid);
}
