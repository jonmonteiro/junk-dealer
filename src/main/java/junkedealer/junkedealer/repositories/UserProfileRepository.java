package junkedealer.junkedealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import junkedealer.junkedealer.entities.UserProfile;
import junkedealer.junkedealer.entities.Users;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
