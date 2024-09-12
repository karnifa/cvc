package br.com.cvc.infra.mapper.systur;

import br.com.cvc.core.dto.CityDTO;
import br.com.cvc.infra.resource.systur.CityResource;
import org.mapstruct.Mapper;

@Mapper
public interface CityResourceMapper {

    CityDTO resourceToDTO(CityResource cityResource);
}
