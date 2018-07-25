package br.com.lasa.poc.authrestapi.controllers;

import br.com.lasa.poc.authrestapi.dtos.LoginRequestDTO;
import br.com.lasa.poc.authrestapi.dtos.LoginResponseDTO;
import br.com.lasa.poc.authrestapi.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
public class AuthController {

    private LoginService loginService;

    private String authHeaderValue;

    public AuthController(
            LoginService loginService,
            @Value("${api.auth.header.value}") String authHeaderValue) {

        this.loginService = loginService;
        this.authHeaderValue = authHeaderValue;
    }

    @RequestMapping( path = "/api/login", method = RequestMethod.POST )
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto) {

        if (!loginService.check(dto.getUsername(), dto.getPassword())) {

            return ResponseEntity.badRequest().body(Collections.singletonMap("message", "Invalid username and password"));
        }

        LoginResponseDTO response = new LoginResponseDTO(
                dto.getUsername(),
                Collections.singletonList("ADMIN"),
                authHeaderValue,
                60
        );

        return ResponseEntity.ok(response);
    }
}
