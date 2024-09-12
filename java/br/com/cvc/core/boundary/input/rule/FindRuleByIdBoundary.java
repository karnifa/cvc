package br.com.cvc.core.boundary.input.rule;

import br.com.cvc.core.dto.RuleDTO;

@FunctionalInterface
public interface FindRuleByIdBoundary {

    RuleDTO execute(Long id);
}
