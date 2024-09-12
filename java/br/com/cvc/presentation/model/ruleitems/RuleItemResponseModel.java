package br.com.cvc.presentation.model.ruleitems;

import br.com.cvc.presentation.model.parameter.ParameterTypeResponseModel;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record RuleItemResponseModel(
        @Schema(example = "1", description = "Código da regra.", required = true)
        @NotNull
        Long id,

        @Schema(description = "Dados sobre o tipo de parâmetro.", required = true)
        @NotNull
        ParameterTypeResponseModel parameterType,

        @Schema(example = "Valor 1", description = "Descrição do valor 1.", required = true)
        @Size(min = 1, max = 255)
        @NotEmpty
        String value1,

        @Schema(example = "Valor 2", description = "Descrição do valor 2.")
        String value2,

        @Schema(example = "Valor 3", description = "Descrição do valor 3.")
        String value3,

        @Schema(example = "Valor 4", description = "Descrição do valor 4.")
        String value4,

        @Schema(example = "Valor 5", description = "Descrição do valor 5.")
        String value5,

        @Schema(example = "Paulo Tito", description = "Nome do ultimo usuário que trabalhou com o registro.", required = true)
        @Size(max = 40)
        @NotEmpty
        String user,

        @Schema(description = "Data da última atualização do registro.")
        String updatedAt) {}