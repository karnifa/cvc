package br.com.cvc.core.boundary.input.group;

import br.com.cvc.core.dto.GroupDTO;
import br.com.cvc.core.dto.pagination.ListDTO;
import br.com.cvc.core.dto.pagination.PageAndSortRequestParametersDTO;

@FunctionalInterface
public interface GetAllGroupsBoundary {

    ListDTO<GroupDTO> execute(PageAndSortRequestParametersDTO pageAndSortParameters);
}
