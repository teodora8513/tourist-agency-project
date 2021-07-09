package rs.ac.bg.fon.naprednajava.touristagency.security.authorization;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("(hasRole(T(rs.ac.bg.fon.naprednajava.touristagency.service.RoleService).ROLE_ADMIN))")
public @interface IsAdminUser {
}
