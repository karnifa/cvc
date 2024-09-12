package br.com.cvc.presentation.model.groupitem;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record GroupItemResponseModel(
        @Schema(example = "1", description = "Código do item do grupo.", required = true)
        @NotNull
        Long id,

        @Schema(example = "1", description = "Código do grupo.", required = true)
        @NotNull
        Long groupId,

        @Schema(example = "Valor 1", description = "Valor da descriçáo do tipo de parâmetro 1.", required = true)
        @NotEmpty
        String value1,

        @Schema(example = "Valor 2", description = "Valor descriçáo do tipo de parâmetro 2. Obrigátorio se o tipo de parâmetro 2 estiver preenchido.")
        String value2,

        @Schema(example = "Valor 3", description = "Valor descriçáo do tipo de parâmetro 3. Obrigátorio se o tipo de parâmetro 3 estiver preenchido.")
        String value3,

        @Schema(example = "Valor 4", description = "Valor descriçáo do tipo de parâmetro 4. Obrigátorio se o tipo de parâmetro 4 estiver preenchido.")
        String value4,

        @Schema(example = "Valor 5", description = "Valor descriçáo do tipo de parâmetro 5. Obrigátorio se o tipo de parâmetro 5 estiver preenchido.")
        String value5,

        @Schema(example = "Paulo Tito", description = "Nome do ultimo usuário que trabalhou com o registro.", required = true)
        @Size(max = 40)
        @NotEmpty
        String user,
        
        @Schema(description = "Data da última atualização do registro.")
        String updatedAt) {}