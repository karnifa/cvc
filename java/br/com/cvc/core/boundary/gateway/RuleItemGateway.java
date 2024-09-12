package br.com.cvc.core.boundary.gateway;

import br.com.cvc.core.dto.RuleItemDTO;

import java.util.List;

public interface RuleItemGateway {

    List<RuleItemDTO> save(final List<RuleItemDTO> ruleItemDTOs);

    List<RuleItemDTO> findAllByRuleId(final Long ruleId);

    void deleteAll(final List<RuleItemDTO> ruleItemDTOs);
}
