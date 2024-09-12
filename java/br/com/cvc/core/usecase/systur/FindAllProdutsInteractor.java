package br.com.cvc.core.usecase.systur;

import br.com.cvc.core.boundary.gateway.corpauth.AuthorizeUserApplicationInCorpAuthGateway;
import br.com.cvc.core.boundary.gateway.systur.FindAllProdutsGateway;
import br.com.cvc.core.boundary.input.systur.FindAllProdutsBoundary;
import br.com.cvc.core.dto.ProductDTO;
import br.com.cvc.core.dto.corpauth.OrcCorpAuthLoginRequestDTO;
import br.com.cvc.core.util.ClientApps;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllProdutsInteractor implements FindAllProdutsBoundary {

    private final AuthorizeUserApplicationInCorpAuthGateway authorizeUserApplicationInCorpAuthGateway;
    private final FindAllProdutsGateway findAllProdutsGateway;
    @Override
    public List<ProductDTO> execute(String uuid) {
        final var orcCorpAuthLoginResponseDTO = this.authorizeUserApplicationInCorpAuthGateway.execute(new OrcCorpAuthLoginRequestDTO(uuid, ClientApps.ACL_SPRINGBOOT_PAYMENT_METHODS));
        final var allObjects = this.findAllProdutsGateway.execute(orcCorpAuthLoginResponseDTO.accessToken(), uuid);
        return allObjects.data();
    }
}
