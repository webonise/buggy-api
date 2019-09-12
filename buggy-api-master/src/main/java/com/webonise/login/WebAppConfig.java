package com.webonise.login;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * We do NOT have the EnableWebMvc annotation here so we
 * get all that Spring Boot autoconfiguration mojo!
 *
 * Lots of search results include EnableWebMvc
 * but don't mention that it disables autoconfiguration.
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    private static final String SWAGGER_UI_HTML = "swagger-ui.html";
    private static final String WEBJARS = "/webjars/**";
    private static final String CONFIGURATION_UI = "/configuration/ui/**";
    private static final String SWAGGER_RESOURCES = "/swagger-resources/**";
    private static final String CLASSPATH_META_INF_RESOURCES_WEBJARS = "classpath:/META-INF/resources/webjars/";
    private static final String CLASSPATH_META_INF_RESOURCES = "classpath:/META-INF/resources/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler(SWAGGER_UI_HTML).addResourceLocations(CLASSPATH_META_INF_RESOURCES);
        resourceHandlerRegistry.addResourceHandler(WEBJARS).addResourceLocations(CLASSPATH_META_INF_RESOURCES_WEBJARS);
        resourceHandlerRegistry.addResourceHandler(CONFIGURATION_UI).addResourceLocations(CLASSPATH_META_INF_RESOURCES);
        resourceHandlerRegistry.addResourceHandler(SWAGGER_RESOURCES).addResourceLocations(CLASSPATH_META_INF_RESOURCES);
    }
    
}
