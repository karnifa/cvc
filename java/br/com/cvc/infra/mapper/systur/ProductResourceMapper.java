package br.com.cvc.infra.mapper.systur;

import br.com.cvc.core.dto.ProductDTO;
import br.com.cvc.infra.resource.systur.ProductResource;
import org.mapstruct.Mapper;

@Mapper
public interface ProductResourceMapper {

    ProductDTO resourceToDTO(ProductResource productResource);
}
