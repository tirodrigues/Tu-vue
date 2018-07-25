package br.com.lasa.poc.authrestapi.dtos;

import java.util.List;

public class LoginResponseDTO {

    private String username;

    private List<String> roles;

    private String token;

    private Integer expiresIn;

    public LoginResponseDTO() { }

    public LoginResponseDTO(String username, List<String> roles, String token, Integer expiresIn) {
        this.username = username;
        this.roles = roles;
        this.token = token;
        this.expiresIn = expiresIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }
}
