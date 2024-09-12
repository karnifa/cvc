package br.com.cvc.presentation.model.systur;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

@JsonNaming
public record SystemResponseModel(
        @Schema(example = "WEB", description = "Código do sistema.", required = true)
        @NotBlank
        String code,

        @Schema(example = "Site CVC Deslogado", description = "Nome do sistema.", required = true)
        @NotBlank
        String name) {}
