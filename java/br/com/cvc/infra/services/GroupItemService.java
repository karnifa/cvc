package br.com.cvc.infra.services;

import br.com.cvc.core.boundary.gateway.GroupItemGateway;
import br.com.cvc.core.dto.GroupItemDTO;
import br.com.cvc.infra.entity.GroupItemEntity;
import br.com.cvc.infra.mapper.GroupItemEntityMapper;
import br.com.cvc.infra.repository.GroupItemRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GroupItemService implements GroupItemGateway {

    private final GroupItemRepository groupItemRepository;
    private final GroupItemEntityMapper mapper;

    @Override
    public List<GroupItemDTO> save(List<GroupItemDTO> groupItemDTOS) {
        List<GroupItemEntity> groupItemEntities = groupItemDTOS.stream().distinct().map(mapper::dtoToEntity).toList();
        return groupItemRepository.saveAll(groupItemEntities).stream().map(mapper::entityToDTO).toList();
    }

    @Override
    public List<GroupItemDTO> findAllByGroupId(final Long groupId) {
        return groupItemRepository.findAllByGroupId(groupId).stream().map(mapper::entityToDTO).toList();
    }

    @Override
    public void deleteAll(List<GroupItemDTO> groupItemDTOS) {
        final var entities = groupItemDTOS.stream()
                .map(this.mapper::dtoToEntity)
                .collect(Collectors.toList());
        this.groupItemRepository.deleteAll(entities);
    }
}
