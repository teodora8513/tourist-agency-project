package rs.ac.bg.fon.naprednajava.touristagency.repository.authority;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserEntity;

import java.util.Optional;

/**
 * User Repository
 * @author mdjukanovic
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * Find user by username
     * @param username username
     * @return optional of User entity
     */
    Optional<UserEntity> findByUsername(String username);
}
