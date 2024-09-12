package br.com.cvc.core.boundary.gateway;

import br.com.cvc.core.dto.ParameterTypeDTO;

import java.util.List;

public interface ParameterTypeGateway {

    ParameterTypeDTO findById (Long id);
    List<ParameterTypeDTO> getAllGroupParameterType();
}
