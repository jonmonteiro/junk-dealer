package junkedealer.junkedealer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import junkedealer.junkedealer.DTO.Users.PostUsersDTO;
import junkedealer.junkedealer.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<PostUsersDTO> createUser(@RequestBody PostUsersDTO user) {
        PostUsersDTO saveUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
    }
}
