package br.com.cvc.presentation.controller.parametertype;

import br.com.cvc.presentation.model.error.ErrorDetails;
import br.com.cvc.presentation.model.parameter.ParameterTypeResponseModel;
import br.com.cvc.presentation.util.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Tipo de parâmetros")
@ApiResponses(value = {
		@ApiResponse(responseCode = "404", description = Constants.API_RESPONSE_404, content = @Content(schema = @Schema())),
		@ApiResponse(responseCode = "500", description = Constants.API_RESPONSE_500, content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
		@ApiResponse(responseCode = "503", description = Constants.API_RESPONSE_503, content = @Content(schema = @Schema())) })
public sealed interface ParameterTypeAPI permits ParameterTypeRestController {

	@Operation(summary = "Lista todos os tipos de parâmetros.")
	@ApiResponse(responseCode = "200", description = Constants.API_RESPONSE_200)
	List<ParameterTypeResponseModel> getAllParameterTypes();
}
