package br.com.cvc.core.boundary.input.systur;

import br.com.cvc.core.dto.PackageGroupDTO;

import java.util.List;

@FunctionalInterface
public interface FindAllPackageGroupsBoundary {

    List<PackageGroupDTO> execute(String uuid);
}
