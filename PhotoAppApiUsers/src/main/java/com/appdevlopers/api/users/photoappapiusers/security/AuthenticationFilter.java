package com.appdevlopers.api.users.photoappapiusers.security;

import com.appdevlopers.api.users.photoappapiusers.service.UsersService;
import com.appdevlopers.api.users.photoappapiusers.shared.UserDto;
import com.appdevlopers.api.users.photoappapiusers.ui.model.LoginRequestModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;

import static io.jsonwebtoken.SignatureAlgorithm.HS512;


public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final UsersService usersService;
    private final Environment environment;

    public AuthenticationFilter(
            UsersService usersService,
            Environment environment,
            AuthenticationManager authenticationManager) {

        super(authenticationManager);
        this.usersService = usersService;
        this.environment = environment;
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws AuthenticationException {

        try {
            LoginRequestModel credentials = new ObjectMapper()
                    .readValue(request.getInputStream(), LoginRequestModel.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getEmail(),
                            credentials.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication auth
    ) throws IOException, ServletException {

        String userName = getUserNameFromAuthentication(auth);
        UserDto userDetails = usersService.getUserDetailsByEmail(userName);

        SecretKey secretKey = getSecretKeyFromEnvironment();
        Date expiration = getExpirationDateFromEnvironment();

        String token = generateToken(userDetails, secretKey, expiration);

        addTokenToResponseHeader(response, token);
        addUserIdToResponseHeader(response, userDetails.getUserId());
    }

    private String getUserNameFromAuthentication(Authentication auth) {
        return ((User) auth.getPrincipal()).getUsername();
    }

    private SecretKey getSecretKeyFromEnvironment() {
        String tokenSecret = Objects.requireNonNull(environment.getProperty("token.secret"));
        byte[] secretBytes = Base64.getEncoder().encode(tokenSecret.getBytes());
        return new SecretKeySpec(secretBytes, HS512.getJcaName());
    }

    private Date getExpirationDateFromEnvironment() {
        return Date.from(Instant.now().plusMillis(Long.parseLong(Objects.requireNonNull(environment
                .getProperty("token.expiration_time")))));
    }

    private String generateToken(UserDto userDetails, SecretKey secretKey, Date expiration) {
        return Jwts.builder()
                .subject(userDetails.getUserId())
                .expiration(expiration)
                .issuedAt(Date.from(Instant.now()))
                .signWith(secretKey)
                .compact();
    }

    private void addTokenToResponseHeader(HttpServletResponse response, String token) {
        response.addHeader("token", token);
    }

    private void addUserIdToResponseHeader(HttpServletResponse response, String userId) {
        response.addHeader("userId", userId);
    }

}

