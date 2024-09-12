package br.com.cvc.core.boundary.input.group;

import br.com.cvc.core.dto.GroupDTO;

@FunctionalInterface
public interface SaveGroupBoundary {

    GroupDTO execute(GroupDTO groupDTO);
}
