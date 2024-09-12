package br.com.cvc.core.boundary.gateway;

import br.com.cvc.core.dto.GroupItemDTO;

import java.util.List;

public interface GroupItemGateway {

    List<GroupItemDTO> save(final List<GroupItemDTO> groupItemDTOS);

    List<GroupItemDTO> findAllByGroupId(final Long groupId);

    void deleteAll(final List<GroupItemDTO> groupItemDTOS);
}
