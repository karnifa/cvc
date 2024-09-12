package br.com.cvc.core.usecase.rule;

import br.com.cvc.core.boundary.gateway.RuleGateway;
import br.com.cvc.core.boundary.gateway.RuleItemGateway;
import br.com.cvc.core.boundary.input.rule.DeleteRuleBoundary;
import br.com.cvc.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class DeleteRuleInteractor implements DeleteRuleBoundary {

    private final RuleGateway ruleGateway;
    private final RuleItemGateway ruleItemGateway;

    @Override
    @Transactional
    public void execute(Long id) {
        if(this.ruleGateway.findById(id) == null) {
            throw new NotFoundException("Regra não encontrada.");
        }

        final var ruleItems = this.ruleItemGateway.findAllByRuleId(id);
        this.ruleItemGateway.deleteAll(ruleItems);
        this.ruleGateway.delete(id);
    }
}
