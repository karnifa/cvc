package br.com.cvc.core.boundary.gateway.systur;

import br.com.cvc.core.dto.AllObjectsDTO;
import br.com.cvc.core.dto.SupplierDTO;

@FunctionalInterface
public interface FindAllSuppliersByParamsGateway {

    AllObjectsDTO<SupplierDTO> execute(String token, String uuid);
}
