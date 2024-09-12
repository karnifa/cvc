package br.com.cvc.presentation.controller.groupitem;

import br.com.cvc.core.boundary.input.groupitems.GetAllGroupItemsByGroupId;
import br.com.cvc.presentation.mapper.groupitem.GroupItemResponseModelMapper;
import br.com.cvc.presentation.model.groupitem.GroupItemResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/group-items")
@RequiredArgsConstructor
@CrossOrigin(origins = {"https://fe-react-payment-methods.k8s-ti-cvc.com.br",
						"https://fe-react-payment-methods.k8s-qa-cvc.com.br",
						"https://fe-react-payment-methods.k8s-cvc.com.br"})
public final class GroupItemRestController implements GroupItemAPI {

	private final GetAllGroupItemsByGroupId getAllGroupItemsByGroupId;
	private final GroupItemResponseModelMapper groupItemResponseModelMapper;

	@Override
	@GetMapping(path = "/v1/group/{groupId}/all")
	@ResponseStatus(HttpStatus.OK)
	public List<GroupItemResponseModel> findAllByGroupId(@PathVariable Long groupId) {
		final var groupItemsDTOs = this.getAllGroupItemsByGroupId.execute(groupId);
		return groupItemsDTOs.stream()
				.map(this.groupItemResponseModelMapper::dtoToModel)
				.collect(Collectors.toList());
	}
}
