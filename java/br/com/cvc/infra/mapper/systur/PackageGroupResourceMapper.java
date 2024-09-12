package br.com.cvc.infra.mapper.systur;

import br.com.cvc.core.dto.PackageGroupDTO;
import br.com.cvc.infra.resource.systur.PackageGroupResource;
import org.mapstruct.Mapper;

@Mapper
public interface PackageGroupResourceMapper {

    PackageGroupDTO resourceToDTO(PackageGroupResource packageGroupResource);
}
