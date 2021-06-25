package rs.ac.bg.fon.naprednajava.touristagency.service.impl.authority;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserEntity;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.authority.UserCreateMapper;
import rs.ac.bg.fon.naprednajava.touristagency.mapper.authority.UserViewMapper;
import rs.ac.bg.fon.naprednajava.touristagency.repository.authority.UserRepository;
import rs.ac.bg.fon.naprednajava.touristagency.requests.authority.CreateUserRequest;
import rs.ac.bg.fon.naprednajava.touristagency.service.RoleService;
import rs.ac.bg.fon.naprednajava.touristagency.service.UserService;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.ValidationException;
import java.util.Objects;

/**
 * Implementation of the User Service
 *
 * @author mdjukanovic
 */
@Service
@Transactional
public class DefaultUserService implements UserService {

    /** User Repository **/
    private final UserRepository userRepository;

    /** Password encoder **/
    private final PasswordEncoder passwordEncoder;

    /** User View Mapper **/
    private final UserViewMapper userViewMapper;

    /** User Create Mapper **/
    private final UserCreateMapper userCreateMapper;

    /** Role Service **/
    private final RoleService roleService;

    public DefaultUserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                              UserViewMapper userViewMapper, UserCreateMapper userCreateMapper,
                              RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userViewMapper = userViewMapper;
        this.userCreateMapper = userCreateMapper;
        this.roleService = roleService;
    }

    /**
     * Creates user
     * @param createUserRequest userRequest to save
     * @return User DTO
     */
    @Override
    public UserDto createUser(CreateUserRequest createUserRequest) {
        Objects.requireNonNull(createUserRequest);

        if(this.userRepository.findByUsername(createUserRequest.getUsername()).isPresent()) {
            throw new ValidationException("Username exists!");
        }

        if(!StringUtils.equals(createUserRequest.getPassword(), createUserRequest.getRePassword())) {
            throw new ValidationException("Passwords don't match");
        }

        UserEntity userEntity = this.userCreateMapper.toEntity(createUserRequest);
        userEntity.setPassword(this.passwordEncoder.encode(userEntity.getPassword()));

        userEntity = this.userRepository.save(userEntity);

        userEntity = this.roleService.addUserToRole(userEntity.getId(), RoleService.ROLE_USER);

        return this.userViewMapper.toDto(userEntity);
    }

    /**
     * Update User
     * @param userEntity userEntity to update
     * @return User Entity
     */
    @Override
    public UserEntity save(UserEntity userEntity) {
        Objects.requireNonNull(userEntity);
        Objects.requireNonNull(userEntity.getId());

        this.userRepository.findById(userEntity.getId()).orElseThrow(() ->
                new EntityNotFoundException("User with that id does not exists!")
        );
        return this.userRepository.save(userEntity);
    }

    /**
     * Search users by id
     * @param id id of the user for search
     * @return User Entity
     */
    @Override
    public UserEntity findById(Long id) {
        Objects.requireNonNull(id);

        return this.userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("User with that id does not exists"));
    }

}
