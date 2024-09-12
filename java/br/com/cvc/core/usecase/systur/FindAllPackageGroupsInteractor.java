package br.com.cvc.core.usecase.systur;

import br.com.cvc.core.boundary.gateway.corpauth.AuthorizeUserApplicationInCorpAuthGateway;
import br.com.cvc.core.boundary.gateway.systur.FindAllPackageGroupsGateway;
import br.com.cvc.core.boundary.input.systur.FindAllPackageGroupsBoundary;
import br.com.cvc.core.dto.PackageGroupDTO;
import br.com.cvc.core.dto.corpauth.OrcCorpAuthLoginRequestDTO;
import br.com.cvc.core.util.ClientApps;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllPackageGroupsInteractor implements FindAllPackageGroupsBoundary {
    private final AuthorizeUserApplicationInCorpAuthGateway authorizeUserApplicationInCorpAuthGateway;
    private final FindAllPackageGroupsGateway findAllPackageGroupsGateway;

    @Override
    public List<PackageGroupDTO> execute(String uuid) {
        final var orcCorpAuthLoginResponseDTO = this.authorizeUserApplicationInCorpAuthGateway.execute(new OrcCorpAuthLoginRequestDTO(uuid, ClientApps.ACL_SPRINGBOOT_PAYMENT_METHODS));
        final var allObjects = this.findAllPackageGroupsGateway.execute(orcCorpAuthLoginResponseDTO.accessToken(), uuid);
        return allObjects.data();
    }
}
