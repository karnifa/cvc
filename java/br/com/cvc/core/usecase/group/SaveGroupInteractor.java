package br.com.cvc.core.usecase.group;

import br.com.cvc.core.boundary.gateway.GroupGateway;
import br.com.cvc.core.boundary.gateway.GroupItemGateway;
import br.com.cvc.core.boundary.input.group.SaveGroupBoundary;
import br.com.cvc.core.dto.GroupDTO;
import br.com.cvc.core.dto.GroupItemDTO;
import br.com.cvc.core.exception.DuplicatedEntityException;
import br.com.cvc.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SaveGroupInteractor implements SaveGroupBoundary {

    private final GroupGateway groupGateway;
    private final GroupItemGateway groupItemGateway;

    @Override
    public GroupDTO execute(final GroupDTO groupDTO) {
        List<GroupItemDTO> groupItemDTOS = groupDTO.getGroupItems();
        this.checkGroupDuplicity(groupDTO);

        if (groupDTO.getId() == null) {
            var savedGroupDTO = this.saveGroup(groupDTO);
            this.saveGroupItens(groupItemDTOS, savedGroupDTO.getId());
            return savedGroupDTO;
        } else {
            var oldGroup = this.groupGateway.findById(groupDTO.getId());

            if(oldGroup == null) {
                throw new NotFoundException("Grupo não encontrado.");
            }

            var oldGroupItems = this.groupItemGateway.findAllByGroupId(oldGroup.getId());
            this.deleteGroupItems(oldGroupItems);
            var savedGroupDTO = this.saveGroup(groupDTO);
            this.saveGroupItens(groupItemDTOS, groupDTO.getId());
            return savedGroupDTO;
        }
    }

    private void checkGroupDuplicity(GroupDTO group) {
        if (Boolean.TRUE.equals(this.groupGateway.existsGroupWithSameName(group))) {
            throw new DuplicatedEntityException("Grupo já cadastrado com este nome.");
        }
    }

    private GroupDTO saveGroup(GroupDTO groupDTO) {
        groupDTO.setGroupItems(null);
        return this.groupGateway.save(groupDTO);
    }

    private void deleteGroupItems(List<GroupItemDTO> groupItemDTOs) {
        if(!groupItemDTOs.isEmpty()) {
            this.groupItemGateway.deleteAll(groupItemDTOs);
        }
    }

    private void saveGroupItens( List<GroupItemDTO> groupItemDTOS, Long groupId) {
        groupItemDTOS.forEach(groupItemDTO -> groupItemDTO.setGroupId(groupId));
        this.groupItemGateway.save(groupItemDTOS);
    }
}

