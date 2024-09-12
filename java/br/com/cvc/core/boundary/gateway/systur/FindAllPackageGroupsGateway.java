package br.com.cvc.core.boundary.gateway.systur;

import br.com.cvc.core.dto.AllObjectsDTO;
import br.com.cvc.core.dto.PackageGroupDTO;

@FunctionalInterface
public interface FindAllPackageGroupsGateway {

    AllObjectsDTO<PackageGroupDTO> execute(String token, String uuid);
}
