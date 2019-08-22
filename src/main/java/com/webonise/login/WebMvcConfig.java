package com.webonise.login;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * We do NOT have the EnableWebMvc annotation here so we
 * get all that Spring Boot autoconfiguration mojo!
 *
 * Lots of search results include EnableWebMvc
 * but don't mention that it disables autoconfiguration.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

}
