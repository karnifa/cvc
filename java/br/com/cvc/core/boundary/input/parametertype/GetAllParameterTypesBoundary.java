package br.com.cvc.core.boundary.input.parametertype;

import br.com.cvc.core.dto.ParameterTypeDTO;

import java.util.List;

@FunctionalInterface
public interface GetAllParameterTypesBoundary {

    List<ParameterTypeDTO> execute();
}
