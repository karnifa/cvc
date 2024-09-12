package br.com.cvc.core.usecase.groupitems;

import br.com.cvc.core.boundary.gateway.GroupItemGateway;
import br.com.cvc.core.boundary.input.groupitems.GetAllGroupItemsByGroupId;
import br.com.cvc.core.dto.GroupItemDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllGroupItemsByGroupIdIntercator implements GetAllGroupItemsByGroupId {

    private final GroupItemGateway groupItemGateway;

    @Override
    public List<GroupItemDTO> execute(final Long groupId) {
        return this.groupItemGateway.findAllByGroupId(groupId);
    }
}
