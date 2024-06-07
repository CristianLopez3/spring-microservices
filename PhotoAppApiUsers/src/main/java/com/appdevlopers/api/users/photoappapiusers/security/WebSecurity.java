package com.appdevlopers.api.users.photoappapiusers.security;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurity {



    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.disable());

        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(new AntPathRequestMatcher("/users/**")).permitAll()
//                        .access(new WebExpressionAuthorizationManager("hasIpAddress(\"192.168.0.0/16\") or hasIpA1ddress(\"127.0.0.0/16\")"))
//                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                )
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        http.headers((headers) -> headers.frameOptions((frameOptions) -> frameOptions.sameOrigin()));

        return http.build();

    }


}

