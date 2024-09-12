package br.com.cvc.infra.services;

import br.com.cvc.core.boundary.gateway.RuleGateway;
import br.com.cvc.core.dto.RuleDTO;
import br.com.cvc.core.dto.pagination.ListDTO;
import br.com.cvc.core.dto.pagination.PageAndSortRequestParametersDTO;
import br.com.cvc.infra.entity.RuleEntity;
import br.com.cvc.infra.mapper.RuleEntityMapper;
import br.com.cvc.infra.repository.RuleRepository;
import br.com.cvc.infra.util.QueryUtils;
import br.com.cvc.infra.util.RuleSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RuleService implements RuleGateway {

    private final RuleRepository ruleRepository;
    private final RuleEntityMapper ruleEntityMapper;

    @Override
    public RuleDTO save(RuleDTO ruleDTO) {
        var entity = this.ruleEntityMapper.dtoToEntity(ruleDTO);
        var persistedEntity = this.ruleRepository.save(entity);
        return this.ruleEntityMapper.entityToDTO(persistedEntity);
    }

    @Override
    public ListDTO<RuleDTO> findAllByParams(PageAndSortRequestParametersDTO pageAndSortParameters, final String name, final String user) {
        Specification<RuleEntity> specification = RuleSpecification.generateListSpecification(name, user);
        Pageable pageable = QueryUtils.getPagination(pageAndSortParameters);
        Page<RuleEntity> foundEntities = this.ruleRepository.findAll(specification, pageable);
        List<RuleDTO> dtos = foundEntities.stream().map(this.ruleEntityMapper::entityToDTO).toList();
        dtos = dtos.stream().distinct().toList();
        return new ListDTO<>(this.ruleRepository.count(), dtos);
    }

    @Override
    public void delete(Long id) {
        this.ruleRepository.deleteById(id);
    }

    @Override
    public RuleDTO findById(Long id) {
        Optional<RuleEntity> foundEntity = this.ruleRepository.findById(id);
        return foundEntity.map(this.ruleEntityMapper::entityToDTO).orElse(null);
    }

    @Override
    public Boolean existsWithSameName(RuleDTO ruleDTO) {
        long count = (ruleDTO.getId() == null)  ? this.ruleRepository.countByName(ruleDTO.getName())
                : this.ruleRepository.countByNameAndIdNot(ruleDTO.getName(), ruleDTO.getId());
        return count > 0;
    }

    @Override
    public ListDTO<RuleDTO> getAll(PageAndSortRequestParametersDTO pageAndSortParameters) {
        Pageable pageable = QueryUtils.getPagination(pageAndSortParameters);
        Page<RuleEntity> foundEntities = this.ruleRepository.findAll(pageable);
        List<RuleDTO> dtos = foundEntities.stream().map(this.ruleEntityMapper::entityToDTO).toList();
        dtos = dtos.stream().distinct().toList();
        return new ListDTO<>(this.ruleRepository.count(), dtos);
    }
}
