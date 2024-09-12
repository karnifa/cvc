package br.com.cvc.presentation.model.systur;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

@JsonNaming
public record StateResponseModel(

        @Schema(example = "SP", description = "Sigla do estado.", required = true)
        @NotBlank
        String id,

        @Schema(example = "SAO PAULO", description = "Nome do estado.", required = true)
        @NotBlank
        String name) {}
