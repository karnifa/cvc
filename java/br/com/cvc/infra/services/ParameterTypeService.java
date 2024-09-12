package br.com.cvc.infra.services;

import br.com.cvc.core.boundary.gateway.ParameterTypeGateway;
import br.com.cvc.core.dto.ParameterTypeDTO;
import br.com.cvc.core.exception.NotFoundException;
import br.com.cvc.infra.mapper.ParameterTypeEntityMapper;
import br.com.cvc.infra.repository.ParameterTypeRepository;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
public class ParameterTypeService implements ParameterTypeGateway {

    private final ParameterTypeRepository parameterTypeRepository;
    private final ParameterTypeEntityMapper parameterTypeEntityMapper;

    @Override
    @Transactional
    public ParameterTypeDTO findById(Long id) {
        final var parameterTypeEntity = this.parameterTypeRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Tipo de parâmetro não encontrado."));
        return this.parameterTypeEntityMapper.entityToDTO(parameterTypeEntity);
    }

    @Override
    @Transactional
    public List<ParameterTypeDTO> getAllGroupParameterType() {
        return this.parameterTypeRepository.findAll()
                .stream()
                .map(this.parameterTypeEntityMapper::entityToDTO)
                .toList();
    }

}
