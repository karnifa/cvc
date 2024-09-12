package br.com.cvc.presentation.controller.group;

import br.com.cvc.core.boundary.input.group.*;
import br.com.cvc.core.dto.pagination.ListDTO;
import br.com.cvc.core.dto.pagination.PageAndSortRequestParametersDTO;
import br.com.cvc.presentation.mapper.group.CreateGroupModelMapper;
import br.com.cvc.presentation.mapper.group.GroupWithParamaterTypeResponseModelMapper;
import br.com.cvc.presentation.model.group.GroupRequestModel;
import br.com.cvc.presentation.model.group.GroupWithParameterTypeResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public final class GroupRestController implements GroupAPI {

	private final SaveGroupBoundary saveGroupBoundary;
	private final FindGroupByIdBoundary findGroupByIdBoundary;
	private final FindAllGroupsByParamsBoundary findAllGroupsByParamsBoundary;
	private final GetAllGroupsBoundary getAllGroupsBoundary;
	private final DeleteGroupBoundary deleteGroupBoundary;
	private final CreateGroupModelMapper createGroupModelMapper;
	private final GroupWithParamaterTypeResponseModelMapper groupWithParamaterTypeResponseModelMapper;

	@Override
	@GetMapping(path = "/v1/params")
	@ResponseStatus(HttpStatus.OK)
	public ListDTO<GroupWithParameterTypeResponseModel> findAllGroupsByParams(PageAndSortRequestParametersDTO pageAndSortParameters,
																			  @RequestParam(value = "parameterTypeId", required = false) Long parameterTypeId,
																			  @RequestParam(value = "name", required = false) String name,
																			  @RequestParam(value = "user", required = false) String user) {
		final var groupDTOs = this.findAllGroupsByParamsBoundary.execute(pageAndSortParameters, parameterTypeId, name, user);
		return this.groupWithParamaterTypeResponseModelMapper.dtoToModel(groupDTOs);
	}

	@Override
	@GetMapping(path = "/v1/all")
	@ResponseStatus(HttpStatus.OK)
	public ListDTO<GroupWithParameterTypeResponseModel> getAllGroups(PageAndSortRequestParametersDTO pageAndSortParameters) {
		final var groupDTOs = this.getAllGroupsBoundary.execute(pageAndSortParameters);
		return this.groupWithParamaterTypeResponseModelMapper.dtoToModel(groupDTOs);
	}

	@Override
	@GetMapping(path = "/v1/id/{id}")
	@ResponseStatus(HttpStatus.OK)
	public GroupWithParameterTypeResponseModel findGroupById(@PathVariable Long id) {
		final var groupDTO = this.findGroupByIdBoundary.execute(id);
		return this.groupWithParamaterTypeResponseModelMapper.dtoToModel(groupDTO);
	}

	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void create(@RequestBody @Valid GroupRequestModel groupRequestModel) {
		final var groupDTO = this.createGroupModelMapper.modelToDTO(groupRequestModel, null);
		this.saveGroupBoundary.execute(groupDTO);
	}

	@Override
	@PutMapping(path = "/v1/update/id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable @Valid Long id, @RequestBody @Valid GroupRequestModel groupRequestModel) {
		final var groupDTO = this.createGroupModelMapper.modelToDTO(groupRequestModel, id);
		this.saveGroupBoundary.execute(groupDTO);
	}

	@Override
	@DeleteMapping(path = "/v1/id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		this.deleteGroupBoundary.execute(id);
	}
}
