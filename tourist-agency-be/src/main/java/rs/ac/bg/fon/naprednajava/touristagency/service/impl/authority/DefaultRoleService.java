package rs.ac.bg.fon.naprednajava.touristagency.service.impl.authority;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.RoleEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserEntity;
import rs.ac.bg.fon.naprednajava.touristagency.repository.authority.RoleRepository;
import rs.ac.bg.fon.naprednajava.touristagency.repository.authority.UserRepository;
import rs.ac.bg.fon.naprednajava.touristagency.service.RoleService;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;

/**
 * Implementation of Role Service
 *
 * @author mdjukanovic
 */
@Service
@AllArgsConstructor
public class DefaultRoleService implements RoleService {

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;


    @Override
    public UserEntity addUserToRole(Long userId, String role) {
        Objects.requireNonNull(userId);
        Objects.requireNonNull(role);

        if(!StringUtils.startsWith(role, PREFIX)) {
            role = PREFIX + role;
        }

        UserEntity userEntity = this.userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Could not find user with that id"));

        RoleEntity roleEntity = this.roleRepository.findByAuthority(role)
                .orElseThrow(() -> new EntityNotFoundException("Could not find role with that name"));

        userEntity.getAuthorities().add(roleEntity);

        return this.userRepository.save(userEntity);
    }
}
