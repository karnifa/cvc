package br.com.cvc.presentation.model.systur;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonNaming
public record CityResponseModel(

        @Schema(example = "148", description = "Id da cidade.", required = true)
        @NotNull
        Long id,

        @Schema(example = "CARMELÓPOLIS", description = "Nome da cidade.", required = true)
        @NotBlank
        String name) {}
