package br.com.cvc.core.usecase.systur;

import br.com.cvc.core.boundary.gateway.corpauth.AuthorizeUserApplicationInCorpAuthGateway;
import br.com.cvc.core.boundary.gateway.systur.FindAllSuppliersByParamsGateway;
import br.com.cvc.core.boundary.input.systur.FindAllSuppliersByParamsBoundary;
import br.com.cvc.core.dto.SupplierDTO;
import br.com.cvc.core.dto.corpauth.OrcCorpAuthLoginRequestDTO;
import br.com.cvc.core.util.ClientApps;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllSuppliersByParamsInteractor implements FindAllSuppliersByParamsBoundary {

    private final AuthorizeUserApplicationInCorpAuthGateway authorizeUserApplicationInCorpAuthGateway;
    private final FindAllSuppliersByParamsGateway findAllSuppliersByParamsGateway;
    @Override
    public List<SupplierDTO> execute(String uuid) {
        final var orcCorpAuthLoginResponseDTO = this.authorizeUserApplicationInCorpAuthGateway.execute(new OrcCorpAuthLoginRequestDTO(uuid, ClientApps.ACL_SPRINGBOOT_PAYMENT_METHODS));
        final var allObjects = this.findAllSuppliersByParamsGateway.execute(orcCorpAuthLoginResponseDTO.accessToken(), uuid);
        return allObjects.data();
    }
}
