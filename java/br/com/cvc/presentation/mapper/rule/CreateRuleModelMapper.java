package br.com.cvc.presentation.mapper.rule;

import br.com.cvc.core.dto.RuleDTO;
import br.com.cvc.core.dto.RuleItemDTO;
import br.com.cvc.presentation.model.rule.RuleRequestModel;
import br.com.cvc.presentation.model.ruleitems.RuleItemRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface CreateRuleModelMapper {

    RuleDTO modelToDTO(RuleRequestModel ruleRequestModel, Long id);

    List<RuleItemDTO> ruleItemRequestModelListToRuleItemDTOList(List<RuleItemRequestModel> list);

    @Mapping(target = "parameterType.id", source = "ruleItemRequestModel.parameterTypeId")
    RuleItemDTO ruleItemRequestModelToRuleItemDTO(RuleItemRequestModel ruleItemRequestModel);
}
