package it.its.TestDockerService.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.its.TestDockerService.dto.AuthenticationRequestDto;
import it.its.TestDockerService.dto.AuthenticationResponseDto;
import it.its.TestDockerService.dto.BaseResponseDto;
import it.its.TestDockerService.repository.UtentiRepository;
import it.its.TestDockerService.security.JwtTokenProvider;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UtentiRepository users;

    @PostMapping("/signin")
//    @PreAuthorize("ADMIN")
    public BaseResponseDto<AuthenticationResponseDto> signin(@Valid @RequestBody AuthenticationRequestDto data) {

    	BaseResponseDto<AuthenticationResponseDto> response = new BaseResponseDto<AuthenticationResponseDto>();
    	
        try {
            String username = data.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token = jwtTokenProvider.createToken(username, this.users.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found")).getRoles());

            AuthenticationResponseDto resp = new AuthenticationResponseDto();
            resp.setUsername(username);
            resp.setToken(token);
            
            response.setStatus(HttpStatus.OK.value());
            response.setResponse(resp);
            
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
		return response;
    }
}

