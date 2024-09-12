package br.com.cvc.presentation.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
@Getter
public class MyConsulPropertiesConfig {

    @Value("${acl-springboot-payment-methods.config.baseurl}")
    private String aclPaymentMethodsBaseURL;

    @Value("${orc-springboot-corp-auth.config.baseurl}")
    private String authBaseURL;
}
