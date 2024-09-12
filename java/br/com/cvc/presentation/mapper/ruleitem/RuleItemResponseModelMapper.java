package br.com.cvc.presentation.mapper.ruleitem;

import br.com.cvc.core.dto.RuleItemDTO;
import br.com.cvc.presentation.model.ruleitems.RuleItemResponseModel;
import org.mapstruct.Mapper;

@Mapper
public interface RuleItemResponseModelMapper {

    RuleItemResponseModel dtoToModel(RuleItemDTO ruleItemDTO);
}
