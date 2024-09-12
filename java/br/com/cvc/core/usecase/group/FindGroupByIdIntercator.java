package br.com.cvc.core.usecase.group;

import br.com.cvc.core.boundary.input.group.FindGroupByIdBoundary;
import br.com.cvc.core.boundary.gateway.GroupItemGateway;
import br.com.cvc.core.boundary.gateway.GroupGateway;
import br.com.cvc.core.dto.GroupDTO;
import br.com.cvc.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindGroupByIdIntercator implements FindGroupByIdBoundary {

    private final GroupGateway groupGateway;
    private final GroupItemGateway groupItemGateway;

    @Override
    public GroupDTO execute(final Long id) {
        var groupDTO = groupGateway.findById(id);

        if (groupDTO == null) {
            throw new NotFoundException("Nenhum grupo encontrado.");
        }

        final var groupItems = this.groupItemGateway.findAllByGroupId(id);
        groupDTO.setGroupItems(groupItems);
        return groupDTO;
    }
}
