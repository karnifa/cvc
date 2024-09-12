package br.com.cvc.presentation.model.systur;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

@JsonNaming
public record BranchResponseModel(
        @Schema(example = "5180288", description = "Id da filial na gen_pessoa.", required = true)
        @NotNull
        Long id,

        @Schema(example = "9440", description = "Código da filial.", required = true)
        @NotNull
        Long code,

        @Schema(example = "CVC GUARUJÁ CENTER", description = "Nome fantasia da filial.", required = true)
        @NotNull
        String name,

        @Schema(example = "Guarujá", description = "Onde a filial está localizada.")
        String location,

        @Schema(example = "true", description = "Indica se a filial é própria.", required = true)
        @NotNull
        Boolean ownBranch) {}