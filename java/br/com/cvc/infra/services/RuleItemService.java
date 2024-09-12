package br.com.cvc.infra.services;

import br.com.cvc.core.boundary.gateway.RuleItemGateway;
import br.com.cvc.core.dto.RuleItemDTO;
import br.com.cvc.infra.entity.RuleItemEntity;
import br.com.cvc.infra.mapper.RuleItemEntityMapper;
import br.com.cvc.infra.repository.RuleItemRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RuleItemService implements RuleItemGateway {

    private final RuleItemRepository ruleItemRepository;
    private final RuleItemEntityMapper ruleItemEntityMapper;

    @Override
    public List<RuleItemDTO> save(List<RuleItemDTO> ruleItemDTOs) {
        List<RuleItemEntity> entities = ruleItemDTOs.stream().map(ruleItemEntityMapper::dtoToEntity).toList();
        return this.ruleItemRepository.saveAll(entities).stream().map(ruleItemEntityMapper::entityToDTO).toList();
    }

    @Override
    public List<RuleItemDTO> findAllByRuleId(final Long ruleId) {
        return this.ruleItemRepository.findAllByRuleId(ruleId).stream().map(ruleItemEntityMapper::entityToDTO).toList();
    }

    @Override
    public void deleteAll(List<RuleItemDTO> ruleItemDTOs) {
        final var entities = ruleItemDTOs.stream()
                .map(this.ruleItemEntityMapper::dtoToEntity)
                .collect(Collectors.toList());
        this.ruleItemRepository.deleteAll(entities);
    }
}
