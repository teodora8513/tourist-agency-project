package rs.ac.bg.fon.naprednajava.touristagency.service.impl.authority;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.RoleEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserEntity;
import rs.ac.bg.fon.naprednajava.touristagency.service.AuthorizationService;

import java.util.Set;

/**
 * Default implementation for Authorization Service
 * @author mdjukanovic
 */
@Service
public class DefaultAuthorizationService implements AuthorizationService {

    /**
     * {@inheritDoc}
     */
    @Override
    public UserEntity getAuthenticatedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated()){
            return null;
        }

        return (UserEntity) authentication.getPrincipal();
    }

    /**
     * {@inheritDoc}
     */
    @Override @SuppressWarnings("unchecked")
    public Set<RoleEntity> getAuthorizedUserRoles(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated()){
            return null;
        }

        return (Set<RoleEntity>) authentication.getAuthorities();
    }
}
