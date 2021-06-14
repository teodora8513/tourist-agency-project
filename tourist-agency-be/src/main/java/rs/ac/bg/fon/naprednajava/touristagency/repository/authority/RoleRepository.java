package rs.ac.bg.fon.naprednajava.touristagency.repository.authority;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.RoleEntity;

import java.util.Optional;

/**
 * Role Repository
 * @author mdjukanovic
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    /**
     * Find role by authority
     * @param authority authority
     * @return optional of RoleEntity
     */
    Optional<RoleEntity> findByAuthority(String authority);

    /**
     * Find role by display name
     * @param displayName displayName
     * @return optional of RoleEntity
     */
    Optional<RoleEntity> findByDisplayName(String displayName);
}
