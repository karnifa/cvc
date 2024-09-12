package br.com.cvc.presentation.model.systur;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

@JsonNaming
public record ProductResponseModel(
        @Schema(example = "CHI", description = "Id do produto.", required = true)
        @NotBlank
        String id,

        @Schema(example = "Chip", description = "Nome do produto.", required = true)
        @NotBlank
        String name) {}
