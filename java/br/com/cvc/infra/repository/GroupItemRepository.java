package br.com.cvc.infra.repository;

import br.com.cvc.infra.entity.GroupItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupItemRepository extends JpaRepository<GroupItemEntity, Long> {
    List<GroupItemEntity> findAllByGroupId(Long groupId);
}
