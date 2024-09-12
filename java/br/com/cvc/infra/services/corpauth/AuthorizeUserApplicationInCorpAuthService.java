package br.com.cvc.infra.services.corpauth;

import br.com.cvc.core.boundary.gateway.corpauth.AuthorizeUserApplicationInCorpAuthGateway;
import br.com.cvc.core.dto.corpauth.OrcCorpAuthLoginRequestDTO;
import br.com.cvc.core.dto.corpauth.OrcCorpAuthLoginResponseDTO;
import br.com.cvc.core.dto.log.LogDTO;
import br.com.cvc.core.dto.log.RequestDTO;
import br.com.cvc.core.dto.log.ResponseDTO;
import br.com.cvc.core.enums.LogServiceEnum;
import br.com.cvc.core.enums.LogTypeEnum;
import br.com.cvc.core.exception.OrcCorpAuthException;
import br.com.cvc.infra.mapper.corpauth.OrcCorpAuthResponseResourceMapper;
import br.com.cvc.infra.resource.corpauth.OrcCorpAuthResponseResource;
import br.com.cvc.infra.util.ParseToJsonUtils;
import br.com.cvc.presentation.config.MyConsulPropertiesConfig;
import br.com.cvc.presentation.config.VaultPropertiesConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Objects;

@RequiredArgsConstructor
public class AuthorizeUserApplicationInCorpAuthService implements AuthorizeUserApplicationInCorpAuthGateway {

    private final MyConsulPropertiesConfig myConsulPropertiesConfig;
    private final VaultPropertiesConfig vaultPropertiesConfig;
    private final RestTemplate restTemplate;
    private final ParseToJsonUtils parseToJsonUtils;
    private final OrcCorpAuthResponseResourceMapper orcCorpAuthResponseResourceMapper;

    @Override
    public OrcCorpAuthLoginResponseDTO execute(OrcCorpAuthLoginRequestDTO orcCorpAuthLoginRequestDTO) {
        final var url = this.getURL(orcCorpAuthLoginRequestDTO.applicationId(), false);
        final var httpMethod = HttpMethod.POST;
        final var headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT_LANGUAGE, "pt-BR");
        final var requestDTO = new RequestDTO(httpMethod.toString(), this.getURL(orcCorpAuthLoginRequestDTO.applicationId(), true), headers.toString(), null);

        try {
            ResponseEntity<OrcCorpAuthResponseResource> response = this.restTemplate.exchange(url, httpMethod, new HttpEntity<>(headers), OrcCorpAuthResponseResource.class);
            final var logDTO = new LogDTO(orcCorpAuthLoginRequestDTO.uuid(), LocalDateTime.now(), null, LogServiceEnum.ORC_SPRINGBOOT_CORP_AUTH.toString(), LogTypeEnum.ORC_SPRINGBOOT_CORP_AUTH_LOGIN.toString(), requestDTO, new ResponseDTO(HttpStatus.OK.value(), this.parseToJsonUtils.execute(response.getBody())), null);
            return this.orcCorpAuthResponseResourceMapper.resourceToDTO(response.getBody()).withLog(logDTO);
        } catch (HttpClientErrorException | HttpServerErrorException exception) {
            final var logDTO = new LogDTO(orcCorpAuthLoginRequestDTO.uuid(), LocalDateTime.now(), null, LogServiceEnum.ORC_SPRINGBOOT_CORP_AUTH.toString(), LogTypeEnum.ORC_SPRINGBOOT_CORP_AUTH_LOGIN.toString(), requestDTO, new ResponseDTO(exception.getRawStatusCode(), exception.getResponseBodyAsString()), null);
            throw new OrcCorpAuthException(logDTO);
        }
    }

    private String getURL(String applicationId, boolean isHiddenPassword) {
        if(isHiddenPassword) {
            return Objects.requireNonNull(this.myConsulPropertiesConfig.getAuthBaseURL(), "Property 'orc-springboot-corp-auth.config.baseurl' is not registered and it is mandatory.")
                    .concat("/v1/login")
                    .concat("?grant_type=implicit_corp&username={username}&password={password}&client={client}")
                    .replace("{username}", this.vaultPropertiesConfig.getCorpAuthUsername())
                    .replace("{password}", this.vaultPropertiesConfig.getCorpAuthPassword().replaceAll("\\w(?=\\w{4})", "*"))
                    .replace("{client}", applicationId);
        }
        return Objects.requireNonNull(this.myConsulPropertiesConfig.getAuthBaseURL(), "Property 'orc-springboot-corp-auth.config.baseurl' is not registered and it is mandatory.")
                .concat("/v1/login")
                .concat("?grant_type=implicit_corp&username={username}&password={password}&client={client}")
                .replace("{username}", this.vaultPropertiesConfig.getCorpAuthUsername())
                .replace("{password}", this.vaultPropertiesConfig.getCorpAuthPassword())
                .replace("{client}", applicationId);
    }
}
