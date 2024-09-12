package br.com.cvc.core.boundary.input.group;

import br.com.cvc.core.dto.GroupDTO;
import br.com.cvc.core.dto.pagination.PageAndSortRequestParametersDTO;
import br.com.cvc.core.dto.pagination.ListDTO;

@FunctionalInterface
public interface FindAllGroupsByParamsBoundary {

    ListDTO<GroupDTO> execute(PageAndSortRequestParametersDTO pageAndSortParameters, Long parameterTypeId, String name, String user);
}
