package br.com.cvc.presentation.model.systur;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

@JsonNaming
public record PackageGroupResponseModel(

        @Schema(example = "STD", description = "Id do grupo de pacote.", required = true)
        @NotBlank
        String id,

        @Schema(example = "Standalone", description = "Nome do grupo de pacote.", required = true)
        @NotBlank
        String name) {}
