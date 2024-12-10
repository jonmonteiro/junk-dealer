package junkedealer.junkedealer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import jakarta.validation.Valid;
import junkedealer.junkedealer.DTO.Users.GetUsersDTO;
import junkedealer.junkedealer.DTO.Users.PostUsersDTO;
import junkedealer.junkedealer.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid PostUsersDTO user, UriComponentsBuilder uriBuilder) {
        GetUsersDTO savedUser = userService.createUser(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(savedUser.id()).toUri();
        return ResponseEntity.created(uri).body(savedUser);
    }
}
