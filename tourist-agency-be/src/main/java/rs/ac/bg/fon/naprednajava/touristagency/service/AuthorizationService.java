package rs.ac.bg.fon.naprednajava.touristagency.service;

import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.RoleEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserEntity;

import java.util.Set;

/**
 * Service for handling Authorization related operations
 * @author mdjukanovic
 */
public interface AuthorizationService{

    /**
     * Retrieves the currently authenticated user (user that is performing requests)
     * @return UserEntity for authenticated user
     */
    UserEntity getAuthenticatedUser();

    /**
     * Retrieves the authorities of the currently authenticated user
     * @return Set of RoleEntities for authenticated user
     */
    Set<RoleEntity> getAuthorizedUserRoles();
}
