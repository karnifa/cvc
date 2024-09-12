package br.com.cvc.infra.repository;

import br.com.cvc.infra.entity.RuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends JpaRepository<RuleEntity, Long>, JpaSpecificationExecutor<RuleEntity> {

    long countByName(String name);

    long countByNameAndIdNot(String name, Long id);
}
