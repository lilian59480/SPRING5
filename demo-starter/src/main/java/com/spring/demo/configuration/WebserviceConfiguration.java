package com.spring.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Example Configuration for Rest
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
@Configuration
public class WebserviceConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
