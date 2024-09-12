package br.com.cvc.presentation.model.group;

import br.com.cvc.presentation.model.groupitem.GroupItemRequestModel;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public record GroupRequestModel(

        @Schema(example = "Grupo 1", description = "Nome do grupo", required = true)
        @Size(max = 40)
        @NotEmpty
        String name,

        @Schema(example = "1", description = "Código do tipo de parâmetro", required = true)
        @NotNull
        Long parameterTypeId,

        @Schema(example = "Paulo Tito", description = "Nome do ultimo usuário que trabalhou com o registro.", required = true)
        @Size(max = 40)
        @NotEmpty
        String user,

        @Schema(description = "Lista de items do grupo.")
        @Size(min = 1)
        @Valid
        List<GroupItemRequestModel> groupItems) { }
