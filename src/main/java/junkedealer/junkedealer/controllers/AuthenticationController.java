package junkedealer.junkedealer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import junkedealer.junkedealer.DTO.Login.AuthenticationDTO;
import junkedealer.junkedealer.DTO.Login.LoginResponseDTO;
import junkedealer.junkedealer.DTO.Login.RegisterDTO;
import junkedealer.junkedealer.entities.Users;
import junkedealer.junkedealer.repositories.UserRepository;
import junkedealer.junkedealer.services.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Users) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
   
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Users newUser = new Users(data.email(), data.name(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
