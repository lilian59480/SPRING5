package com.spring.demo.configuration;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Example Configuration for Swagger
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.buildApiInfo());
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfo("Demo Api",
                "Demo to learn Spring",
                env.getProperty("application.version", "undefined"),
                "",
                new Contact("Lilian Petitpas", "localhost", "lilian.petitpas@localhost"),
                "",
                "",
                Collections.emptyList()
        );
    }
}
