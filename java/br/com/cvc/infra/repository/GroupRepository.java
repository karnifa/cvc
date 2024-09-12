package br.com.cvc.infra.repository;

import br.com.cvc.infra.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Long>, JpaSpecificationExecutor<GroupEntity> {

    long countByName(String name);

    long countByNameAndIdNot(String name, Long id);
}
