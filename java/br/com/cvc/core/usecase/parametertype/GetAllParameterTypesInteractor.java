package br.com.cvc.core.usecase.parametertype;

import br.com.cvc.core.boundary.gateway.ParameterTypeGateway;
import br.com.cvc.core.boundary.input.parametertype.GetAllParameterTypesBoundary;
import br.com.cvc.core.dto.ParameterTypeDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllParameterTypesInteractor implements GetAllParameterTypesBoundary {

    private final ParameterTypeGateway parameterTypeGateway;

    @Override
    public List<ParameterTypeDTO> execute() {
        return this.parameterTypeGateway.getAllGroupParameterType();
    }
}
