package br.com.lasa.poc.authrestapi.filters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;

@Component
public class StatelessAuthenticationFilter extends GenericFilterBean {

    @Value("${api.auth.header.name}")
    private String authHeaderName;

    @Value("${api.auth.header.value}")
    private String authHeaderValue;

    @Value("${api.auth.user.username}")
    private String defaultUsername;

    @Value("${api.auth.user.password}")
    private String defaultPassword;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        if (authHeaderValue.equals(httpServletRequest.getHeader(authHeaderName))) {

            Authentication token = new UsernamePasswordAuthenticationToken(
                    defaultUsername,
                    defaultPassword,
                    Collections.singletonList(new SimpleGrantedAuthority("ADMIN"))
            );

            SecurityContextHolder.getContext().setAuthentication(token);
        }

        chain.doFilter(request, response);

        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
