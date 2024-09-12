package br.com.cvc.presentation.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Value("${app.version}")
	private String appVersion;

	@Bean
	public OpenAPI create() {
		return new OpenAPI().info(getInfo()).components(getComponents()).addSecurityItem(getSecurityItem());
	}

	private Components getComponents() {
		return new Components().addSecuritySchemes("bearerAuth", getSecurityScheme());
	}

	private SecurityScheme getSecurityScheme() {
		return new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT");
	}

	private SecurityRequirement getSecurityItem() {
		return new SecurityRequirement().addList("bearerAuth");
	}



	private Info getInfo() {
		return new Info().title("Orquestrador de formas de pagamento")
				.description(this.getIntroduction())
				.version(this.appVersion).contact(
				new Contact().name("Squad serviços financeiros e meios de pagamento").email("SquadSFM@cvccorp.com.br"));
	}

	private String getIntroduction() {
		return "<html>" +
				"<h3>Introdução</h3> Projeto responsável por gerenciar as formas de pagamento da CVC.<br><br>" +
				"As APIs contidas nessa documentação seguem as regras definidas na arquitetura REST e utilizam o JSON como formato de troca de dados. <br><br>" +
				"Para autorização e autenticação, foi adotado o oAuth 2.0 como protocolo de segurança. Entre em contato com o time de Serviços financeiros e meios de pagamento para solicitar as credenciais necessárias de integração. <br><br>" +

				"<h3>Para se autenticar</h3>\n\n" +
				"Insira o token gerado do curl abaixo, de acordo com seu ambiente: <br><br>" +
				"<b>TI</b>: curl --location --request POST 'https://orc-springboot-corp-auth.k8s-ti-cvc.com.br/v1/login?username={{seu_nome_de_usuario}}&password={{sua_senha}}&client=orc-springboot-payment-methods' <br>" +
				"<b>QA</b>: curl --location --request POST 'https://orc-springboot-corp-auth.k8s-qa-cvc.com.br/v1/login?username={{seu_nome_de_usuario}}&password={{sua_senha}}&client=orc-springboot-payment-methods' <br>" +
				"<b>PROD</b>: curl --location --request POST 'https://orc-springboot-corp-auth.k8s-cvc.com.br/v1/login?username={{seu_nome_de_usuario}}&password={{sua_senha}}&client=orc-springboot-payment-methods' <br><br>" +
				"</html>";
	}
}
