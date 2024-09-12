package br.com.cvc.core.boundary.input.systur;

import br.com.cvc.core.dto.SystemDTO;

import java.util.List;

@FunctionalInterface
public interface FindAllSystemsBoundary {

    List<SystemDTO> execute(String uuid);
}
