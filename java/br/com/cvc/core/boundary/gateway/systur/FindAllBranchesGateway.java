package br.com.cvc.core.boundary.gateway.systur;

import br.com.cvc.core.dto.AllObjectsDTO;
import br.com.cvc.core.dto.BranchDTO;

@FunctionalInterface
public interface FindAllBranchesGateway {

    AllObjectsDTO<BranchDTO> execute(String token, String uuid);
}
