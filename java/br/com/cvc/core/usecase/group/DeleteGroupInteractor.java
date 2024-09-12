package br.com.cvc.core.usecase.group;

import br.com.cvc.core.boundary.gateway.GroupGateway;
import br.com.cvc.core.boundary.gateway.GroupItemGateway;
import br.com.cvc.core.boundary.input.group.DeleteGroupBoundary;
import br.com.cvc.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class DeleteGroupInteractor implements DeleteGroupBoundary {

    private final GroupGateway groupGateway;
    private final GroupItemGateway groupItemGateway;

    @Override
    @Transactional
    public void execute(Long id) {
        if(this.groupGateway.findById(id) == null) {
            throw new NotFoundException("Grupo não encontrado.");
        }

        final var groupItensDTO = this.groupItemGateway.findAllByGroupId(id);
        this.groupItemGateway.deleteAll(groupItensDTO);
        this.groupGateway.delete(id);

    }
}
