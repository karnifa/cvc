package br.com.cvc.infra.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.cvc.infra.entity.ParameterTypeEntity;

@Repository
public interface ParameterTypeRepository extends ReadOnlyRepository<ParameterTypeEntity, Long>, JpaSpecificationExecutor<ParameterTypeEntity> {}
