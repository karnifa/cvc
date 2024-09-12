package br.com.cvc.presentation.controller.group;

import br.com.cvc.presentation.model.error.ErrorDetails;
import br.com.cvc.presentation.model.error.ValidationErrorDetails;
import br.com.cvc.core.dto.pagination.ListDTO;
import br.com.cvc.core.dto.pagination.PageAndSortRequestParametersDTO;
import br.com.cvc.presentation.model.group.GroupRequestModel;
import br.com.cvc.presentation.model.group.GroupWithParameterTypeResponseModel;
import br.com.cvc.presentation.util.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Grupo")
@ApiResponses(value = {
		@ApiResponse(responseCode = "400", description = Constants.API_RESPONSE_400, content = @Content(schema = @Schema(implementation = ValidationErrorDetails.class))),
		@ApiResponse(responseCode = "404", description = Constants.API_RESPONSE_404, content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
		@ApiResponse(responseCode = "409", description = Constants.API_RESPONSE_409, content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
		@ApiResponse(responseCode = "422", description = Constants.API_RESPONSE_422, content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
		@ApiResponse(responseCode = "500", description = Constants.API_RESPONSE_500, content = @Content(schema = @Schema(implementation = ErrorDetails.class))),
		@ApiResponse(responseCode = "503", description = Constants.API_RESPONSE_503, content = @Content(schema = @Schema())) })
public sealed interface GroupAPI permits GroupRestController{

	@Operation(summary = "Lista todos os grupos de maneira paginada de acordo com o id de um parâmetro.")
	@ApiResponse(responseCode = "200", description = Constants.API_RESPONSE_200)
	@Parameters(value = {
			@Parameter(in = ParameterIn.QUERY, name = "offset", schema = @Schema(type = "int"), description = "Página de dados da coleção a ser obtida."),
			@Parameter(in = ParameterIn.QUERY, name = "limit", schema = @Schema(type = "int"), description = "Quantidade de itens a serem obtidos na página."),
			@Parameter(in = ParameterIn.QUERY, name = "sort", schema = @Schema(type = "string"), description = "Ordem de ordenação crescente (asc) ou decrescente (desc) baseado na data de atualização do registro."),
			@Parameter(in = ParameterIn.QUERY, name = "sortBy", schema = @Schema(type = "string"), description = "Campo ao qual deve ser feito a ordenação. (DEFAULT = updatedAt)")
	})
	ListDTO<GroupWithParameterTypeResponseModel> findAllGroupsByParams(@Parameter(hidden = true) PageAndSortRequestParametersDTO parameters,
																	   @Parameter(description = "Id do tipo de parâmetro.") Long parameterTypeId,
																	   @Parameter(description = "Nome do grupo.") String name,
																	   @Parameter(description = "Nome do ultimo usuário que trabalhou com o cadastro do grupo.") String user);

	@Operation(summary = "Lista todos os grupos.")
	@ApiResponse(responseCode = "200", description = Constants.API_RESPONSE_200)
	@Parameters(value = {
			@Parameter(in = ParameterIn.QUERY, name = "offset", schema = @Schema(type = "int"), description = "Página de dados da coleção a ser obtida."),
			@Parameter(in = ParameterIn.QUERY, name = "limit", schema = @Schema(type = "int"), description = "Quantidade de itens a serem obtidos na página."),
			@Parameter(in = ParameterIn.QUERY, name = "sort", schema = @Schema(type = "string"), description = "Ordem de ordenação crescente (asc) ou decrescente (desc) baseado na data de atualização do registro."),
			@Parameter(in = ParameterIn.QUERY, name = "sortBy", schema = @Schema(type = "string"), description = "Campo ao qual deve ser feito a ordenação. (DEFAULT = updatedAt)")
	})
	ListDTO<GroupWithParameterTypeResponseModel> getAllGroups(@Parameter(hidden = true) PageAndSortRequestParametersDTO parameters);

	@Operation(summary = "Obtem um grupo de acordo com o id.")
	@ApiResponse(responseCode = "200", description = Constants.API_RESPONSE_200)
	GroupWithParameterTypeResponseModel findGroupById(Long id);

	@Operation(summary = "Salva um novo grupo.")
	@ApiResponse(responseCode = "204", description = Constants.API_RESPONSE_204)
	void create(final GroupRequestModel groupRequestModel);

	@Operation(summary = "Atualiza informações de um grupo de acordo com o id.")
	@ApiResponse(responseCode = "204", description = Constants.API_RESPONSE_204)
	void update(final Long id, final GroupRequestModel groupRequestModel);

	@Operation(summary = "Remove um grupo de acordo com o id.")
	@ApiResponse(responseCode = "204", description = Constants.API_RESPONSE_204)
	void deleteById(final Long id);
}
