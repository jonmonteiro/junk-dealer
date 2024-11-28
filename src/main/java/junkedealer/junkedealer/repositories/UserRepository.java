package junkedealer.junkedealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import junkedealer.junkedealer.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByLogin(String login);
}
