package br.com.cvc.infra.services;

import br.com.cvc.core.boundary.gateway.GroupGateway;
import br.com.cvc.core.dto.GroupDTO;
import br.com.cvc.core.dto.pagination.ListDTO;
import br.com.cvc.core.dto.pagination.PageAndSortRequestParametersDTO;
import br.com.cvc.infra.entity.GroupEntity;
import br.com.cvc.infra.mapper.GroupEntityMapper;
import br.com.cvc.infra.repository.GroupRepository;
import br.com.cvc.infra.util.GroupSpecification;
import br.com.cvc.infra.util.QueryUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class GroupService implements GroupGateway {

    private final GroupRepository groupRepository;
    private final GroupEntityMapper groupEntityMapper;

    @Override
    public GroupDTO save(GroupDTO groupDTO) {
        var groupEntity = this.groupEntityMapper.dtoToEntity(groupDTO);
        var persistedEntity = this.groupRepository.save(groupEntity);
        return this.groupEntityMapper.entityToDTO(persistedEntity);
    }

    @Override
    public ListDTO<GroupDTO> findAllGroupsByParams(PageAndSortRequestParametersDTO pageAndSortParameters, final Long parameterTypeId, final String name, final String user) {
        Specification<GroupEntity> specification = GroupSpecification.generateListSpecification(parameterTypeId, name, user);
        Pageable pageable = QueryUtils.getPagination(pageAndSortParameters);
        Page<GroupEntity> foundEntities = this.groupRepository.findAll(specification, pageable);
        List<GroupDTO> groups = foundEntities.stream().map(this.groupEntityMapper::entityToDTO).toList();
        groups = groups.stream().distinct().toList();
        return new ListDTO<>(this.groupRepository.count(), groups);
    }

    @Override
    public void delete(Long id) {
        this.groupRepository.deleteById(id);
    }

    @Override
    public GroupDTO findById(Long id) {
        Optional<GroupEntity> foundGroup = this.groupRepository.findById(id);
        return foundGroup.map(this.groupEntityMapper::entityToDTO).orElse(null);
    }

    @Override
    public Boolean existsGroupWithSameName(GroupDTO group) {
        long count = (group.getId() == null)  ? this.groupRepository.countByName(group.getName())
                : this.groupRepository.countByNameAndIdNot(group.getName(), group.getId());
        return count > 0;
    }

    @Override
    public ListDTO<GroupDTO> getAllGroups(PageAndSortRequestParametersDTO pageAndSortParameters) {
        Pageable pageable = QueryUtils.getPagination(pageAndSortParameters);
        Page<GroupEntity> foundEntities = this.groupRepository.findAll(pageable);
        List<GroupDTO> groups = foundEntities.stream().map(this.groupEntityMapper::entityToDTO).toList();
        groups = groups.stream().distinct().toList();
        return new ListDTO<>(this.groupRepository.count(), groups);
    }
}
