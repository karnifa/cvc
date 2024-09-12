package br.com.cvc.core.usecase.group;

import br.com.cvc.core.boundary.input.group.FindAllGroupsByParamsBoundary;
import br.com.cvc.core.boundary.gateway.GroupGateway;
import br.com.cvc.core.dto.GroupDTO;
import br.com.cvc.core.dto.pagination.ListDTO;
import br.com.cvc.core.dto.pagination.PageAndSortRequestParametersDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindAllGroupsByParamsInteractor implements FindAllGroupsByParamsBoundary {

    private final GroupGateway groupGateway;

    @Override
    public ListDTO<GroupDTO> execute(PageAndSortRequestParametersDTO pageAndSortParameters, Long parameterTypeId, String name, String user) {
        return this.groupGateway.findAllGroupsByParams(pageAndSortParameters, parameterTypeId, name, user);
    }
}
