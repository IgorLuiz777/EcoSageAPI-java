package br.com.ecosage.config;

import br.com.ecosage.filter.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SecurityConfig {

    @Value("${cors.api}")
    private String api;

    @Bean
    public SecurityFilterChain config(HttpSecurity http, AuthorizationFilter authorizationFilter) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/user").permitAll()
                .requestMatchers(HttpMethod.GET, "/user/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/energyUsage/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/category/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/equipment/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/energyWantedUsage/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/chat/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/chat/**").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/chat/**").permitAll()
                .anyRequest().authenticated()
        );
        http.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
