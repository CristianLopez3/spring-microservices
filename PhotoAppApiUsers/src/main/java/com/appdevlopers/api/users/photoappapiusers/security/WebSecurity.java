package com.appdevlopers.api.users.photoappapiusers.security;

import com.appdevlopers.api.users.photoappapiusers.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Objects;

@Configuration
@EnableWebSecurity
public class WebSecurity {

    private final Environment env;
    private final UsersService usersService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(Environment env, UsersService usersService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.env = env;
        this.usersService = usersService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = configureAuthenticationManager(http);
        AuthenticationFilter authenticationFilter = createAuthenticationFilter(authenticationManager);
        configureHttpRoutes(http, authenticationFilter, authenticationManager);
        configureHttpHeaders(http);
        return http.build();
    }

    private AuthenticationManager configureAuthenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(usersService)
                .passwordEncoder(bCryptPasswordEncoder);
        return authenticationManagerBuilder.build();
    }

    private AuthenticationFilter createAuthenticationFilter(AuthenticationManager authenticationManager) {
        String URL_PATH = Objects.requireNonNull(env.getProperty("login.url.path"));
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(usersService, env, authenticationManager);
        authenticationFilter.setFilterProcessesUrl(URL_PATH);
        return authenticationFilter;
    }

    private void configureHttpRoutes(HttpSecurity http, AuthenticationFilter authenticationFilter, AuthenticationManager authenticationManager) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(new AntPathRequestMatcher("/users/**"))
                        .access(new WebExpressionAuthorizationManager("hasIpAddress('" + env.getProperty("gateway.ip") + "')"))
                )
                .addFilter(authenticationFilter)
                .authenticationManager(authenticationManager)
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    }

    private void configureHttpHeaders(HttpSecurity http) throws Exception {
        http.headers((headers) -> headers.frameOptions((frameOptions) -> frameOptions.sameOrigin()));
    }
}

