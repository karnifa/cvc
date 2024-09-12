package br.com.cvc.presentation.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@Getter
public class VaultPropertiesConfig {

    @Value("${ORC_SPRINGBOOT_CORP_AUTH_USERNAME}")
    private String corpAuthUsername;
    @Value("${ORC_SPRINGBOOT_CORP_AUTH_PASSWORD}")
    private String corpAuthPassword;
    @Value("${SPRING_DATASOURCE_USERNAME}")
    private String dbUsername;
    @Value("${SPRING_DATASOURCE_PASSWORD}")
    private String dbPassword;
}
