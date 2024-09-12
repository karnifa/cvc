package br.com.cvc.presentation.controller.rule;

import br.com.cvc.core.boundary.input.rule.*;
import br.com.cvc.core.dto.pagination.ListDTO;
import br.com.cvc.core.dto.pagination.PageAndSortRequestParametersDTO;
import br.com.cvc.presentation.mapper.rule.CreateRuleModelMapper;
import br.com.cvc.presentation.mapper.rule.RuleWithIdResponseModelMapper;
import br.com.cvc.presentation.model.rule.RuleRequestModel;
import br.com.cvc.presentation.model.rule.RuleWithIdResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rule")
@RequiredArgsConstructor
@CrossOrigin(origins = {"https://fe-react-payment-methods.k8s-ti-cvc.com.br",
						"https://fe-react-payment-methods.k8s-qa-cvc.com.br",
						"https://fe-react-payment-methods.k8s-cvc.com.br"})
public final class RuleRestController implements RuleAPI {

	private final SaveRuleBoundary saveRuleBoundary;
	private final FindRuleByIdBoundary findRuleByIdBoundary;
	private final FindAllRulesByParamsBoundary findAllRulesByParamsBoundary;
	private final GetAllRulesBoundary getAllRulesBoundary;
	private final DeleteRuleBoundary deleteRuleBoundary;
	private final CreateRuleModelMapper createRuleModelMapper;
	private final RuleWithIdResponseModelMapper ruleWithIdResponseModelMapper;

	@Override
	@GetMapping(path = "/v1/params")
	@ResponseStatus(HttpStatus.OK)
	public ListDTO<RuleWithIdResponseModel> findAllByParams(PageAndSortRequestParametersDTO pageAndSortParameters,
															@RequestParam(value = "name", required = false) String name,
															@RequestParam(value = "user", required = false) String user) {
		final var ruleDTOs = this.findAllRulesByParamsBoundary.execute(pageAndSortParameters, name, user);
		return this.ruleWithIdResponseModelMapper.dtoToModel(ruleDTOs);
	}

	@Override
	@GetMapping(path = "/v1/all")
	@ResponseStatus(HttpStatus.OK)
	public ListDTO<RuleWithIdResponseModel> getAll(PageAndSortRequestParametersDTO pageAndSortParameters) {
		final var ruleDTOs = this.getAllRulesBoundary.execute(pageAndSortParameters);
		return this.ruleWithIdResponseModelMapper.dtoToModel(ruleDTOs);
	}

	@Override
	@GetMapping(path = "/v1/id/{id}")
	@ResponseStatus(HttpStatus.OK)
	public RuleWithIdResponseModel findById(@PathVariable Long id) {
		final var ruleDTO = this.findRuleByIdBoundary.execute(id);
		return this.ruleWithIdResponseModelMapper.dtoToModel(ruleDTO);
	}

	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void create(@RequestBody @Valid RuleRequestModel ruleRequestModel) {
		final var ruleDTO = this.createRuleModelMapper.modelToDTO(ruleRequestModel, null);
		this.saveRuleBoundary.execute(ruleDTO);
	}

	@Override
	@PutMapping(path = "/v1/update/id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable @Valid Long id, @RequestBody @Valid RuleRequestModel ruleRequestModel) {
		final var ruleDTO = this.createRuleModelMapper.modelToDTO(ruleRequestModel, id);
		this.saveRuleBoundary.execute(ruleDTO);
	}

	@Override
	@DeleteMapping(path = "/v1/id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		this.deleteRuleBoundary.execute(id);
	}
}
