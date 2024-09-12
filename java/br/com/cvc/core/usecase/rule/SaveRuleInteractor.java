package br.com.cvc.core.usecase.rule;

import br.com.cvc.core.boundary.gateway.RuleGateway;
import br.com.cvc.core.boundary.gateway.RuleItemGateway;
import br.com.cvc.core.boundary.input.rule.SaveRuleBoundary;
import br.com.cvc.core.dto.RuleDTO;
import br.com.cvc.core.dto.RuleItemDTO;
import br.com.cvc.core.exception.DuplicatedEntityException;
import br.com.cvc.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SaveRuleInteractor implements SaveRuleBoundary {

    private final RuleGateway ruleGateway;
    private final RuleItemGateway ruleItemGateway;

    @Override
    public RuleDTO execute(RuleDTO ruleDTO) {
        List<RuleItemDTO> ruleItemDTOS = ruleDTO.getRuleItems();
        this.checkDuplicity(ruleDTO);

        if (ruleDTO.getId() == null) {
            var savedRuleDTO = this.save(ruleDTO);
            this.saveItems(ruleItemDTOS, savedRuleDTO.getId());
            return savedRuleDTO;
        } else {
            var oldRule = this.ruleGateway.findById(ruleDTO.getId());

            if(oldRule == null) {
                throw new NotFoundException("Regra não encontrada.");
            }

            var oldRuleItems = this.ruleItemGateway.findAllByRuleId(oldRule.getId());
            this.deleteItems(oldRuleItems);
            var savedRuleDTO = this.save(ruleDTO);
            this.saveItems(ruleItemDTOS, ruleDTO.getId());
            return savedRuleDTO;
        }
    }

    private void checkDuplicity(RuleDTO ruleDTO) {
        if (Boolean.TRUE.equals(this.ruleGateway.existsWithSameName(ruleDTO))) {
            throw new DuplicatedEntityException("Já existe uma regra cadastrada com esse nome.");
        }
    }

    private RuleDTO save(RuleDTO ruleDTO) {
        ruleDTO.setRuleItems(null);
        return this.ruleGateway.save(ruleDTO);
    }

    private void deleteItems(List<RuleItemDTO> ruleItems) {
        if(!ruleItems.isEmpty()) {
            this.ruleItemGateway.deleteAll(ruleItems);
        }
    }

    private void saveItems(List<RuleItemDTO> ruleItemDTOS, Long ruleId) {
        ruleItemDTOS.forEach(ruleItemDTO -> ruleItemDTO.setRuleId(ruleId));
        this.ruleItemGateway.save(ruleItemDTOS);
    }
}

