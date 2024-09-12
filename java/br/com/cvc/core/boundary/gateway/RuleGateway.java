package br.com.cvc.core.boundary.gateway;

import br.com.cvc.core.dto.RuleDTO;
import br.com.cvc.core.dto.pagination.ListDTO;
import br.com.cvc.core.dto.pagination.PageAndSortRequestParametersDTO;

public interface RuleGateway {

    RuleDTO save(final RuleDTO ruleDTO);

    ListDTO<RuleDTO> findAllByParams(PageAndSortRequestParametersDTO pageAndSortParameters, final String name, final String user);

    void delete(Long id);

    RuleDTO findById(Long id);

    Boolean existsWithSameName(RuleDTO ruleDTO);

    ListDTO<RuleDTO> getAll(PageAndSortRequestParametersDTO pageAndSortParameters);
}
