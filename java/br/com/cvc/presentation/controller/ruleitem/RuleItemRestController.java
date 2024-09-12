package br.com.cvc.presentation.controller.ruleitem;

import br.com.cvc.core.boundary.input.ruleitem.GetAllRuleItemsByRuleId;
import br.com.cvc.presentation.mapper.ruleitem.RuleItemResponseModelMapper;
import br.com.cvc.presentation.model.ruleitems.RuleItemResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rule-items")
@RequiredArgsConstructor
@CrossOrigin(origins = {"https://fe-react-payment-methods.k8s-ti-cvc.com.br",
						"https://fe-react-payment-methods.k8s-qa-cvc.com.br",
						"https://fe-react-payment-methods.k8s-cvc.com.br"})
public final class RuleItemRestController implements RuleItemAPI {

	private final GetAllRuleItemsByRuleId getAllRuleItemsByRuleId;
	private final RuleItemResponseModelMapper ruleItemResponseModelMapper;

	@Override
	@GetMapping(path = "/v1/rule/{ruleId}/all")
	@ResponseStatus(HttpStatus.OK)
	public List<RuleItemResponseModel> findAllByRuleId(@PathVariable Long ruleId) {
		final var ruleItemsDTOs = this.getAllRuleItemsByRuleId.execute(ruleId);
		return ruleItemsDTOs.stream()
				.map(this.ruleItemResponseModelMapper::dtoToModel)
				.collect(Collectors.toList());
	}
}
