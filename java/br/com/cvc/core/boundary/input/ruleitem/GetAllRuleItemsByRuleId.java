package br.com.cvc.core.boundary.input.ruleitem;

import br.com.cvc.core.dto.RuleItemDTO;

import java.util.List;

@FunctionalInterface
public interface GetAllRuleItemsByRuleId {
    List<RuleItemDTO> execute(final Long ruleId);
}
