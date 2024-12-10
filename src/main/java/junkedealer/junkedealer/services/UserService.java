package junkedealer.junkedealer.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import junkedealer.junkedealer.DTO.Users.GetUsersDTO;
import junkedealer.junkedealer.DTO.Users.PostUsersDTO;
import junkedealer.junkedealer.entities.UserProfile;
import junkedealer.junkedealer.entities.Users;
import junkedealer.junkedealer.repositories.UserProfileRepository;
import junkedealer.junkedealer.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public GetUsersDTO createUser(PostUsersDTO data) {
        Set<UserProfile> profiles = userProfileRepository.findAllById(data.idsProfile()).stream().collect(Collectors.toSet());
        String encryptedPassword = passwordEncoder.encode(data.password());

        Users users = new Users(profiles, data.name(), data.login(), data.email(), encryptedPassword);

        if (userRepository.findByLogin(users.getLogin()) != null) {
            throw new DataIntegrityViolationException("Esse LOGIN já está em uso!");
        }
        
		if (userRepository.findByName(users.getName()) != null) {
			throw new DataIntegrityViolationException("Campo duplicado: Nome");
		}
		
		if (userRepository.findByEmail(users.getEmail()) != null) {
			throw new DataIntegrityViolationException("Campo duplicado: Email");
		}

        userRepository.save(users);

        Set<String> profileName = users.getUserProfile().stream().map(profile -> profile.getName().name()).collect(Collectors.toSet());

        return new GetUsersDTO(users.getName(), users.getId(), users.getLogin(), users.getEmail(), profileName);
    }
}
