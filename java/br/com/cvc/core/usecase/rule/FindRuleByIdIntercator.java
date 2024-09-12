package br.com.cvc.core.usecase.rule;

import br.com.cvc.core.boundary.gateway.RuleGateway;
import br.com.cvc.core.boundary.gateway.RuleItemGateway;
import br.com.cvc.core.boundary.input.rule.FindRuleByIdBoundary;
import br.com.cvc.core.dto.RuleDTO;
import br.com.cvc.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindRuleByIdIntercator implements FindRuleByIdBoundary {

    private final RuleGateway ruleGateway;
    private final RuleItemGateway ruleItemGateway;

    @Override
    public RuleDTO execute(final Long id) {
        var ruleDTO = ruleGateway.findById(id);

        if (ruleDTO == null) {
            throw new NotFoundException("Nenhuma regra encontrada.");
        }

        final var items = this.ruleItemGateway.findAllByRuleId(id);
        ruleDTO.setRuleItems(items);
        return ruleDTO;
    }
}
