package br.com.cvc.presentation.model.systur;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonNaming
public record OperationResponseModel(
        @Schema(example = "5404", description = "Id da operação.", required = true)
        @NotNull
        Long id,

        @Schema(example = "VISA", description = "Nome da operação.", required = true)
        @NotBlank
        String name,

        @Schema(example = "5", description = "Id da modalidade.", required = true)
        @NotNull
        Long modalityId,

        @Schema(example = "Cartao de credito", description = "Nome da modalidade.", required = true)
        @NotBlank
        String modalityName,

        @Schema(example = "true", description = "Indica se a operação está ativa.", required = true)
        @NotNull
        Boolean active) {}
