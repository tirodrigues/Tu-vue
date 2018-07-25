package br.com.lasa.poc.authrestapi.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Value("${api.auth.user.username}")
    private String DEFAULT_USERNAME;

    @Value("${api.auth.user.password}")
    private String DEFAULT_PASSWORD;


    public boolean check(String username, String password) {

        return DEFAULT_USERNAME.equals(username) && DEFAULT_PASSWORD.equals(password);
    }
}
