package junkedealer.junkedealer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import junkedealer.junkedealer.DTO.Users.PostUsersDTO;
import junkedealer.junkedealer.entities.Users;
import junkedealer.junkedealer.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public PostUsersDTO createUser(PostUsersDTO data) {
        Users user = new Users();
        user.setName(data.name());
        user.setEmail(data.email());
        String encryptedPassword = passwordEncoder.encode(data.password());
        user.setPassword(encryptedPassword);
        user = userRepository.save(user);
        return new PostUsersDTO(user);
    }
}
