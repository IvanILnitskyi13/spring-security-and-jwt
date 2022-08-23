package ua.ilnitskyi.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ilnitskyi.userservice.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
