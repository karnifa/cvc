package br.com.cvc.core.boundary.gateway.systur;

import br.com.cvc.core.dto.AllObjectsDTO;
import br.com.cvc.core.dto.ProductDTO;

@FunctionalInterface
public interface FindAllProdutsGateway {

    AllObjectsDTO<ProductDTO> execute(String token, String uuid);
}
