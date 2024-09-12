package br.com.cvc.presentation.mapper.systur;

import br.com.cvc.core.dto.SupplierDTO;
import br.com.cvc.presentation.model.systur.SupplierResponseModel;
import org.mapstruct.Mapper;

@Mapper
public interface SupplierResponseModelMapper {

    SupplierResponseModel dtoToModel(SupplierDTO supplierDTO);
}
