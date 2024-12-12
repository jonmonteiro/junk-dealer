package junkedealer.junkedealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import junkedealer.junkedealer.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    UserDetails findByEmail(String email);
}
