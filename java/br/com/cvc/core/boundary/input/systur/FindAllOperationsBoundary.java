package br.com.cvc.core.boundary.input.systur;

import br.com.cvc.core.dto.OperationDTO;

import java.util.List;

@FunctionalInterface
public interface FindAllOperationsBoundary {

    List<OperationDTO> execute(String uuid);
}
