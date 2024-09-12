package br.com.cvc.core.usecase.rule;

import br.com.cvc.core.boundary.gateway.RuleGateway;
import br.com.cvc.core.boundary.input.rule.GetAllRulesBoundary;
import br.com.cvc.core.dto.RuleDTO;
import br.com.cvc.core.dto.pagination.ListDTO;
import br.com.cvc.core.dto.pagination.PageAndSortRequestParametersDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAllRulesInteractor implements GetAllRulesBoundary {

    private final RuleGateway ruleGateway;

    @Override
    public ListDTO<RuleDTO> execute(PageAndSortRequestParametersDTO pageAndSortParameters) {
        return this.ruleGateway.getAll(pageAndSortParameters);
    }
}
