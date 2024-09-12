package br.com.cvc.infra.mapper.systur;

import br.com.cvc.core.dto.SupplierDTO;
import br.com.cvc.infra.resource.systur.SupplierResource;
import org.mapstruct.Mapper;

@Mapper
public interface SupplierResourceMapper {

    SupplierDTO resourceToDTO(SupplierResource supplierResource);
}
