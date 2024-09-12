package br.com.cvc.presentation.controller.systur;

import br.com.cvc.presentation.model.error.ErrorDetails;
import br.com.cvc.presentation.model.error.ValidationErrorDetails;
import br.com.cvc.presentation.model.systur.*;
import br.com.cvc.presentation.util.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Systur")
@ApiResponses(value = {
		@ApiResponse(responseCode = "400", description = Constants.API_RESPONSE_400, content = @Content(schema = @Schema(implementation = ValidationErrorDetails.class))),
		@ApiResponse(responseCode = "404", description = Constants.API_RESPONSE_404, content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
		@ApiResponse(responseCode = "409", description = Constants.API_RESPONSE_409, content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
		@ApiResponse(responseCode = "422", description = Constants.API_RESPONSE_422, content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
		@ApiResponse(responseCode = "500", description = Constants.API_RESPONSE_500, content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
		@ApiResponse(responseCode = "503", description = Constants.API_RESPONSE_503, content = @Content(schema = @Schema())) })
public sealed interface SysturAPI permits SysturRestController {

	@Operation(summary = "Lista todas as filiais.")
	@ApiResponse(responseCode = "200", description = Constants.API_RESPONSE_200)
	List<BranchResponseModel> findAllBranches();

	@Operation(summary = "Lista todas as cidades de acordo com codigo do país e estado.")
	@ApiResponse(responseCode = "200", description = Constants.API_RESPONSE_200)
	List<CityResponseModel> findAllCities(@Parameter(description = "Código do país.") String country,
										  @Parameter(description = "Código do estado.") String state);

	@Operation(summary = "Lista todos os países.")
	@ApiResponse(responseCode = "200", description = Constants.API_RESPONSE_200)
	List<CountryResponseModel> findAllCountries();

	@Operation(summary = "Lista todas as operações.")
	@ApiResponse(responseCode = "200", description = Constants.API_RESPONSE_200)
	List<OperationResponseModel> findAllOperations();

	@Operation(summary = "Lista todos os grupos de pacote.")
	@ApiResponse(responseCode = "200", description = Constants.API_RESPONSE_200)
	List<PackageGroupResponseModel> findAllPackageGroups();

	@Operation(summary = "Lista todos os produtos.")
	@ApiResponse(responseCode = "200", description = Constants.API_RESPONSE_200)
	List<ProductResponseModel> findAllProducts();

	@Operation(summary = "Lista todos os estados de acordo com o codigo do país.")
	@ApiResponse(responseCode = "200", description = Constants.API_RESPONSE_200)
	List<StateResponseModel> findAllStatesByCountryId(@Parameter(description = "Código do país.") String country);

	@Operation(summary = "Lista todos os fornecedores de acordo com parâmetros.")
	@ApiResponse(responseCode = "200", description = Constants.API_RESPONSE_200)
	List<SupplierResponseModel> findAllSupplierByParams();

	@Operation(summary = "Lista todos os sistemas.")
	@ApiResponse(responseCode = "200", description = Constants.API_RESPONSE_200)
	List<SystemResponseModel> findAllSystems();

}
