package rs.ac.bg.fon.naprednajava.touristagency.bootstrap;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.RoleEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserEntity;
import rs.ac.bg.fon.naprednajava.touristagency.repository.authority.RoleRepository;
import rs.ac.bg.fon.naprednajava.touristagency.repository.authority.UserRepository;
import rs.ac.bg.fon.naprednajava.touristagency.service.RoleService;

@Component
public class DefaultAdminBootstrap implements CommandLineRunner {

    @Autowired @Setter
    private UserRepository userRepository;

    @Autowired @Setter
    private RoleRepository roleRepository;

    @Autowired @Setter
    private PasswordEncoder passwordEncoder;

    @Setter
    private String defaultUsername = "admin@admin.com";

    @Setter
    private String defaultPassword = "admin@123";

    @Setter
    private String defaultFirstName = "admin";

    @Setter
    private String defaultLastName = "admin";

    @Override
    public void run(String... args) throws Exception {
        UserEntity adminUser = this.userRepository.findByUsername(this.defaultUsername).orElse(null);
        if(adminUser == null) {
            RoleEntity adminRole = this.getOrCreateAdminRole();

            adminUser = this.createDefaultAdminUser(adminRole);

            this.userRepository.save(adminUser);
        }
    }

    private UserEntity createDefaultAdminUser(RoleEntity adminRole) {
        UserEntity adminUser = new UserEntity();
        adminUser.setUsername(this.defaultUsername);
        adminUser.setPassword(this.defaultPassword);
        adminUser.getAuthorities().add(adminRole);
        adminUser.setFirstName(this.defaultFirstName);
        adminUser.setLastName(this.defaultLastName);


        adminUser.setPassword(this.passwordEncoder.encode(this.defaultPassword));

        return adminUser;
    }

    private RoleEntity getOrCreateAdminRole() {
        RoleEntity adminRole = this.roleRepository.findByAuthority(RoleService.ROLE_ADMIN).orElse(null);
        if(adminRole == null) {
            adminRole = new RoleEntity();
            adminRole.setAuthority(RoleService.ROLE_ADMIN);
            adminRole.setDisplayName(RoleService.DISPLAY_NAME_ADMIN);

            adminRole = this.roleRepository.save(adminRole);
        }

        return adminRole;
    }
}
