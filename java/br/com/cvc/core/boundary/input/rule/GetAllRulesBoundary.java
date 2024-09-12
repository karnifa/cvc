package br.com.cvc.core.boundary.input.rule;

import br.com.cvc.core.dto.RuleDTO;
import br.com.cvc.core.dto.pagination.ListDTO;
import br.com.cvc.core.dto.pagination.PageAndSortRequestParametersDTO;

@FunctionalInterface
public interface GetAllRulesBoundary {

    ListDTO<RuleDTO> execute(PageAndSortRequestParametersDTO pageAndSortParameters);
}
