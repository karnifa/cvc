package br.com.cvc.core.usecase.ruleitems;

import br.com.cvc.core.boundary.gateway.RuleItemGateway;
import br.com.cvc.core.boundary.input.ruleitem.GetAllRuleItemsByRuleId;
import br.com.cvc.core.dto.RuleItemDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllRuleItemsByRuleIdIntercator implements GetAllRuleItemsByRuleId {

    private final RuleItemGateway ruleItemGateway;

    @Override
    public List<RuleItemDTO> execute(final Long ruleId) {
        return this.ruleItemGateway.findAllByRuleId(ruleId);
    }
}
