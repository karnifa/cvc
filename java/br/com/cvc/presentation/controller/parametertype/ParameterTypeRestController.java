package br.com.cvc.presentation.controller.parametertype;

import br.com.cvc.core.boundary.input.parametertype.GetAllParameterTypesBoundary;
import br.com.cvc.presentation.mapper.parametertype.ParamaterTypeResponseModelMapper;
import br.com.cvc.presentation.model.parameter.ParameterTypeResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parameter-type")
@RequiredArgsConstructor
@CrossOrigin(origins = {"https://fe-react-payment-methods.k8s-ti-cvc.com.br",
						"https://fe-react-payment-methods.k8s-qa-cvc.com.br",
						"https://fe-react-payment-methods.k8s-cvc.com.br"})
public final class ParameterTypeRestController implements ParameterTypeAPI {

	private final GetAllParameterTypesBoundary getAllParameterTypesBoundary;
	private final ParamaterTypeResponseModelMapper paramaterTypeResponseModelMapper;

	@Override
	@GetMapping(path = "/v1/all")
	@ResponseStatus(HttpStatus.OK)
	public List<ParameterTypeResponseModel> getAllParameterTypes() {
		final var parameterTypeDTOS = this.getAllParameterTypesBoundary.execute();
		return parameterTypeDTOS.stream()
				.map(this.paramaterTypeResponseModelMapper::dtoToModel)
				.collect(Collectors.toList());
	}
}
