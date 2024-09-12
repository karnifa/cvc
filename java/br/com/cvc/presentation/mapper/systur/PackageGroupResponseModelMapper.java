package br.com.cvc.presentation.mapper.systur;

import br.com.cvc.core.dto.PackageGroupDTO;
import br.com.cvc.presentation.model.systur.PackageGroupResponseModel;
import org.mapstruct.Mapper;

@Mapper
public interface PackageGroupResponseModelMapper {

    PackageGroupResponseModel dtoToModel(PackageGroupDTO packageGroupDTO);
}
