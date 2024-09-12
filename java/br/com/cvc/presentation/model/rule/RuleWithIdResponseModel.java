package br.com.cvc.presentation.model.rule;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record RuleWithIdResponseModel(
        @Schema(example = "1", description = "Código da regra.", required = true)
        @NotNull
        Long id,

        @Schema(example = "Regra 1", description = "Nome da regra.", required = true)
        @Size(max = 40)
        @NotEmpty
        String name,

        @Schema(example = "Paulo Tito", description = "Nome do ultimo usuário que trabalhou com o registro.", required = true)
        @Size(max = 40)
        @NotEmpty
        String user,

        @Schema(description = "Data da última atualização do registro.")
        String updatedAt){}
