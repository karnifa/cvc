package br.com.cvc.presentation.model.systur;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

@JsonNaming
public record CountryResponseModel(

        @Schema(example = "BR", description = "Sigla do país.", required = true)
        @NotBlank
        String id,

        @Schema(example = "Brasil", description = "Nome do país.", required = true)
        @NotBlank
        String name) {}
