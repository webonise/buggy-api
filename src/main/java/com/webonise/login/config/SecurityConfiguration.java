package com.webonise.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Customize the {@link HttpSecurity {@link #configure(HttpSecurity)}} method
     * which disable the csrf token.
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.cors().and().csrf()
                .disable().authorizeRequests()
                .antMatchers("/swagger-resources/*", "*.html", "/api/v1/swagger.json")
                .hasRole("SWAGGER")
                .anyRequest()
                .permitAll();
    }

    /**
     * The method Create the instance of {@link UrlBasedCorsConfigurationSource} which set the
     * properties related allowing the application for cors origin.
     *
     * @return CorsFilter
     */
    @Bean
    @Primary
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(false);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    /**
     * Customizing {@Link WebSecurityConfigurerAdapter {@link #configure(WebSecurity)} }
     * which ignores the swagger urls and from the basic authentication.
     *
     * @param webSecurity
     */
    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring()
                .antMatchers("/v2/api-docs/**",
                        "/configuration/ui/**",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/webjars/**");
    }

}
