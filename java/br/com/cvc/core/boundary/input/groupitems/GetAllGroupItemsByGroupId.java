package br.com.cvc.core.boundary.input.groupitems;

import br.com.cvc.core.dto.GroupItemDTO;

import java.util.List;

@FunctionalInterface
public interface GetAllGroupItemsByGroupId {
    List<GroupItemDTO> execute(final Long groupId);
}
