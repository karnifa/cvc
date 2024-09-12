package br.com.cvc.presentation.controller.groupitem;

import br.com.cvc.presentation.model.error.ErrorDetails;
import br.com.cvc.presentation.model.error.ValidationErrorDetails;
import br.com.cvc.presentation.model.groupitem.GroupItemResponseModel;
import br.com.cvc.presentation.util.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Items de grupo")
@ApiResponses(value = {
		@ApiResponse(responseCode = "400", description = Constants.API_RESPONSE_400, content = @Content(schema = @Schema(implementation = ValidationErrorDetails.class))),
		@ApiResponse(responseCode = "404", description = Constants.API_RESPONSE_404, content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
		@ApiResponse(responseCode = "409", description = Constants.API_RESPONSE_409, content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
		@ApiResponse(responseCode = "422", description = Constants.API_RESPONSE_422, content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
		@ApiResponse(responseCode = "500", description = Constants.API_RESPONSE_500, content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
		@ApiResponse(responseCode = "503", description = Constants.API_RESPONSE_503, content = @Content(schema = @Schema())) })
public sealed interface GroupItemAPI permits GroupItemRestController {

	@Operation(summary = "Lista todos os items de um determinado grupo.")
	@ApiResponse(responseCode = "200", description = Constants.API_RESPONSE_200)
	List<GroupItemResponseModel> findAllByGroupId(@Parameter Long groupId);

}
