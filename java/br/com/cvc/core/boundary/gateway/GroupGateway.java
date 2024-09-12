package br.com.cvc.core.boundary.gateway;

import br.com.cvc.core.dto.GroupDTO;
import br.com.cvc.core.dto.pagination.ListDTO;
import br.com.cvc.core.dto.pagination.PageAndSortRequestParametersDTO;

public interface GroupGateway {

    GroupDTO save(final GroupDTO group);

    ListDTO<GroupDTO> findAllGroupsByParams(PageAndSortRequestParametersDTO pageAndSortParameters, final Long parameterCode, final String name, final String user);

    void delete(Long id);

    GroupDTO findById(Long id);

    Boolean existsGroupWithSameName(GroupDTO group);

    ListDTO<GroupDTO> getAllGroups(PageAndSortRequestParametersDTO pageAndSortParameters);
}
