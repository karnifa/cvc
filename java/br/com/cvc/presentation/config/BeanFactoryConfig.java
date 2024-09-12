package br.com.cvc.presentation.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactoryConfig {

	@Bean
	static BeanFactoryPostProcessor beanFactoryPostProcessor(final ApplicationContext beanRegistry) {
		return (final var beanFactory) -> {
			final var beanDefinitionScanner = new ClassPathBeanDefinitionScanner(
					(BeanDefinitionRegistry) ((AnnotationConfigServletWebServerApplicationContext) beanRegistry)
							.getBeanFactory());
			beanDefinitionScanner.addIncludeFilter((final var mr, final var mrf) -> {
				final var className = mr.getClassMetadata().getClassName();
				return !className.contains("domain") && !className.contains("model") && !className.contains("util")
						&& !className.contains("resource") && !className.contains("enums")
						&& !className.contains("exception") && !className.contains("constantes")
						&& !className.contains("DecodingExceptionHandler") && !className.contains("dto");
			});
			beanDefinitionScanner.scan("br.com.cvc");
		};
	}
}
