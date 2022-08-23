package ua.ilnitskyi.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ilnitskyi.userservice.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
