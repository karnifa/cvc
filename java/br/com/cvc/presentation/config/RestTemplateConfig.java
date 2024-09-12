package br.com.cvc.presentation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    static RestTemplate createRestTemplate() {
        return new RestTemplate();
    }

}
