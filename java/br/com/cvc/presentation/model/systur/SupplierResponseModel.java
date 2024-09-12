package br.com.cvc.presentation.model.systur;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonNaming
public record SupplierResponseModel(
        @Schema(example = "1712239", description = "Id do fornecedor.", required = true)
        @NotNull
        Long id,

        @Schema(example = "HOTEL CAPETONIAN", description = "Nome do fornecedor.", required = true)
        @NotBlank
        String name,

        @Schema(example = "HOTEL CAPETONIAN (CAPE TOWN)", description = "Nome fantasia do fornecedor.")
        String nickname,

        @Schema(example = "10760260000119", description = "Documento do fornecedor.")
        String document) { }
