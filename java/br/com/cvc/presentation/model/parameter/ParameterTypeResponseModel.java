package br.com.cvc.presentation.model.parameter;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record ParameterTypeResponseModel (

    @Schema(example = "1", description = "Código do parâmetro", required = true)
    @NotNull
    Long id,

    @Schema(example = "Grupos", description = "Nome do parâmetro.", required = true)
    @NotEmpty
    String name,

    @Schema(example = "CD_FILIAL_CVC", description = "Valor do parâmetro 1.")
    String valueType1,

    @Schema(example = "TIPO_RESTRICAO", description = "Valor do parâmetro 2.")
    String valueType2,

    @Schema(example = "CD_PESSOA", description = "Valor do parâmetro 3.")
    String valueType3,

    @Schema(example = "CD_SISTEMA", description = "Valor do parâmetro 4.")
    String valueType4,

    @Schema(example = "CD_FORNECEDOR", description = "Valor do parâmetro 5.")
    String valueType5){}
