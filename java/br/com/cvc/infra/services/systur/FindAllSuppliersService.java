package br.com.cvc.infra.services.systur;

import br.com.cvc.core.boundary.gateway.systur.FindAllSuppliersByParamsGateway;
import br.com.cvc.core.dto.AllObjectsDTO;
import br.com.cvc.core.dto.SupplierDTO;
import br.com.cvc.core.dto.log.LogDTO;
import br.com.cvc.core.dto.log.RequestDTO;
import br.com.cvc.core.dto.log.ResponseDTO;
import br.com.cvc.core.enums.LogServiceEnum;
import br.com.cvc.core.enums.LogTypeEnum;
import br.com.cvc.core.exception.FindAllSuppliersException;
import br.com.cvc.infra.mapper.systur.SupplierResourceMapper;
import br.com.cvc.infra.resource.systur.SupplierResource;
import br.com.cvc.infra.util.ParseToJsonUtils;
import br.com.cvc.presentation.config.MyConsulPropertiesConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor //TODO - Felipe - Acrescentar estrutura de log no banco de dados
public class FindAllSuppliersService implements FindAllSuppliersByParamsGateway {

    private final RestTemplate restTemplate;
    private final MyConsulPropertiesConfig myConsulPropertiesConfig;
    private final SupplierResourceMapper supplierResourceMapper;
    private final ParseToJsonUtils parseToJsonUtils;

    @Override
    public AllObjectsDTO<SupplierDTO> execute(String token, String uuid) {
        final var url = this.myConsulPropertiesConfig.getAclPaymentMethodsBaseURL() + "/systur/v1/supplier/all";
        final var httpMethod = HttpMethod.GET;
        final var headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT_LANGUAGE, "pt-BR");
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer ".concat(token));
        final var logRequestDTO = new RequestDTO(httpMethod.toString(), url, headers.toString(), null);

        try {
            final var responseEntity = restTemplate.exchange(url, httpMethod, new HttpEntity<>(headers), new ParameterizedTypeReference<List<SupplierResource>>() {});
            final var logDTO = new LogDTO(uuid, LocalDateTime.now(), null, LogServiceEnum.ACL_SPRINGBOOT_PAYMENT_METHODS.toString(), LogTypeEnum.FIND_ALL_SUPPLIERS_BY_PARAMS.toString(), logRequestDTO, new ResponseDTO(HttpStatus.OK.value(), this.parseToJsonUtils.execute(responseEntity.getBody())), null);
            return new AllObjectsDTO<>(responseEntity.getBody().stream()
                    .map(this.supplierResourceMapper::resourceToDTO)
                    .collect(Collectors.toList()), logDTO);
        } catch (HttpClientErrorException | HttpServerErrorException exception) {
            final var logDTO = new LogDTO(uuid, LocalDateTime.now(), null, LogServiceEnum.ACL_SPRINGBOOT_PAYMENT_METHODS.toString(), LogTypeEnum.FIND_ALL_SUPPLIERS_BY_PARAMS.toString(), logRequestDTO, new ResponseDTO(exception.getRawStatusCode(), exception.getResponseBodyAsString()), null);
            throw new FindAllSuppliersException(logDTO);
        }
    }

}
