package junkedealer.junkedealer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import junkedealer.junkedealer.DTO.AuthData;
import junkedealer.junkedealer.DTO.JwtTokenData;
import junkedealer.junkedealer.entities.Users;
import junkedealer.junkedealer.services.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RestController
@RequestMapping("/login")
public class SecurityController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthData data) {
		var authToken = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
		var auth = authManager.authenticate(authToken);
		var JwtToken = tokenService.generateToken((Users) auth.getPrincipal());
		return ResponseEntity.ok(new JwtTokenData(JwtToken));			
	}
}
