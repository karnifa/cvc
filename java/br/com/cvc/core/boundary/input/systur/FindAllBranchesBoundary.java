package br.com.cvc.core.boundary.input.systur;

import br.com.cvc.core.dto.BranchDTO;

import java.util.List;

@FunctionalInterface
public interface FindAllBranchesBoundary {

    List<BranchDTO> execute(String uuid);
}
