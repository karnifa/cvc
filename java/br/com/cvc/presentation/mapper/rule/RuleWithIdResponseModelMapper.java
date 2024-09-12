package br.com.cvc.presentation.mapper.rule;

import br.com.cvc.core.dto.RuleDTO;
import br.com.cvc.core.dto.pagination.ListDTO;
import br.com.cvc.presentation.model.rule.RuleWithIdResponseModel;
import org.mapstruct.Mapper;

@Mapper
public interface RuleWithIdResponseModelMapper {

    ListDTO<RuleWithIdResponseModel> dtoToModel(ListDTO<RuleDTO> ruleDTOs);

    RuleWithIdResponseModel dtoToModel(RuleDTO ruleDTO);
}
