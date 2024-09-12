package br.com.cvc.infra.repository;

import br.com.cvc.infra.entity.RuleItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleItemRepository extends JpaRepository<RuleItemEntity, Long> {
    List<RuleItemEntity> findAllByRuleId(Long id);
}
