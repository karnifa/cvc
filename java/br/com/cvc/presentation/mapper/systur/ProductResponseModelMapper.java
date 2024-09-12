package br.com.cvc.presentation.mapper.systur;

import br.com.cvc.core.dto.ProductDTO;
import br.com.cvc.presentation.model.systur.ProductResponseModel;
import org.mapstruct.Mapper;

@Mapper
public interface ProductResponseModelMapper {

    ProductResponseModel dtoToModel(ProductDTO productDTO);
}
