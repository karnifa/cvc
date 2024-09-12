package br.com.cvc.core.usecase.group;

import br.com.cvc.core.boundary.input.group.GetAllGroupsBoundary;
import br.com.cvc.core.boundary.gateway.GroupGateway;
import br.com.cvc.core.dto.GroupDTO;
import br.com.cvc.core.dto.pagination.ListDTO;
import br.com.cvc.core.dto.pagination.PageAndSortRequestParametersDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAllGroupsInteractor implements GetAllGroupsBoundary {

    private final GroupGateway groupGateway;

    @Override
    public ListDTO<GroupDTO> execute(PageAndSortRequestParametersDTO pageAndSortParameters) {
        return this.groupGateway.getAllGroups(pageAndSortParameters);
    }
}
