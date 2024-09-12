package br.com.cvc.presentation.mapper.systur;

import br.com.cvc.core.dto.BranchDTO;
import br.com.cvc.presentation.model.systur.BranchResponseModel;
import org.mapstruct.Mapper;

@Mapper
public interface BranchResponseModelMapper {
    BranchResponseModel dtoToModel(BranchDTO branchDTO);
}
