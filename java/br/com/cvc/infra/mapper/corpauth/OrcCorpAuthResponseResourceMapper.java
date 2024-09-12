package br.com.cvc.infra.mapper.corpauth;

import br.com.cvc.core.dto.corpauth.OrcCorpAuthLoginResponseDTO;
import br.com.cvc.infra.resource.corpauth.OrcCorpAuthResponseResource;
import org.mapstruct.Mapper;

@Mapper
public interface OrcCorpAuthResponseResourceMapper {
    OrcCorpAuthLoginResponseDTO resourceToDTO(OrcCorpAuthResponseResource orcCorpAuthResponseResource);
}
