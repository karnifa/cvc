package br.com.cvc.infra.mapper.systur;

import br.com.cvc.core.dto.BranchDTO;
import br.com.cvc.infra.resource.systur.BranchResource;
import org.mapstruct.Mapper;

@Mapper
public interface BranchResourceMapper {

    BranchDTO resourceToDTO(BranchResource branchResource);
}
