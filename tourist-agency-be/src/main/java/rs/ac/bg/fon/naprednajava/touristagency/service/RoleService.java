package rs.ac.bg.fon.naprednajava.touristagency.service;

import rs.ac.bg.fon.naprednajava.touristagency.entity.authority.UserEntity;

public interface RoleService {

    /** User Role **/
    String ROLE_USER = "USER";

    /** Admin Role **/
    String ROLE_ADMIN = "ADMIN";

    /** Display name for user role **/
    String DISPLAY_NAME_USER = "User";

    /** Display name for admin role **/
    String DISPLAY_NAME_ADMIN = "Admin";

    /** Role prefix **/
    String PREFIX = "ROLE_";

    UserEntity addUserToRole(Long userId, String role);
}
