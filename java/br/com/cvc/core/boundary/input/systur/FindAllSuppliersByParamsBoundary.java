package br.com.cvc.core.boundary.input.systur;

import br.com.cvc.core.dto.SupplierDTO;

import java.util.List;

@FunctionalInterface
public interface FindAllSuppliersByParamsBoundary {

    List<SupplierDTO> execute(String uuid);
}
