package ua.ilnitskyi.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.ilnitskyi.userservice.model.Role;
import ua.ilnitskyi.userservice.model.User;
import ua.ilnitskyi.userservice.service.UserService;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityAngJwtTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityAngJwtTokenApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John Doe", "john", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Emma Doe", "emma", "1234", new ArrayList<>()));

            userService.addRoleToUser("john", "ROLE_USER");
            userService.addRoleToUser("jim", "ROLE_MANAGER");
            userService.addRoleToUser("will", "ROLE_ADMIN");
            userService.addRoleToUser("emma", "ROLE_USER");
            userService.addRoleToUser("emma", "ROLE_MANAGER");
            userService.addRoleToUser("emma", "ROLE_ADMIN");
            userService.addRoleToUser("emma", "ROLE_SUPER_ADMIN");

        };
    }

}
