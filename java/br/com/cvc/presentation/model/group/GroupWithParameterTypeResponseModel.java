package br.com.cvc.presentation.model.group;

import br.com.cvc.presentation.model.parameter.ParameterTypeResponseModel;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record GroupWithParameterTypeResponseModel(
        @Schema(example = "1", description = "Código do grupo.", required = true)
        @NotNull
        Long id,

        @Schema(example = "Grupo 1", description = "Nome do grupo.", required = true)
        @Size(max = 40)
        @NotEmpty
        String name,

        @Schema(example = "Paulo Tito", description = "Nome do ultimo usuário que trabalhou com o registro.", required = true)
        @Size(max = 40)
        @NotEmpty
        String user,

        @Schema(description = "Dados sobre o tipo de parâmetro.", required = true)
        @NotNull
        ParameterTypeResponseModel parameterType,

        @Schema(description = "Data da última atualização do registro.")
        String updatedAt){}
