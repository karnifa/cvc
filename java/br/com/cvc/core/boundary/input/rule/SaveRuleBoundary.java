package br.com.cvc.core.boundary.input.rule;

import br.com.cvc.core.dto.RuleDTO;

@FunctionalInterface
public interface SaveRuleBoundary {

    RuleDTO execute(RuleDTO ruleDTO);
}
