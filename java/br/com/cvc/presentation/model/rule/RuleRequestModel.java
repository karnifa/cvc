package br.com.cvc.presentation.model.rule;

import br.com.cvc.presentation.model.ruleitems.RuleItemRequestModel;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public record RuleRequestModel(

        @Schema(example = "Regra 1", description = "Nome da regra.", required = true)
        @Size(max = 40)
        @NotEmpty
        String name,

        @Schema(example = "Paulo Tito", description = "Nome do ultimo usuário que trabalhou com o registro.", required = true)
        @Size(max = 40)
        @NotEmpty
        String user,

        @Schema(description = "Lista de items de regra.")
        @Size(min = 1)
        @Valid
        List<RuleItemRequestModel> ruleItems) { }
