package br.com.cvc.core.boundary.input.systur;

import br.com.cvc.core.dto.ProductDTO;

import java.util.List;

@FunctionalInterface
public interface FindAllProdutsBoundary {

    List<ProductDTO> execute(String uuid);
}
