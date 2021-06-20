package rs.ac.bg.fon.naprednajava.touristagency.entity.authority;

import lombok.Data;
import rs.ac.bg.fon.naprednajava.touristagency.dto.MyDto;

import java.util.Set;

@Data
public class UserDto implements MyDto {

    /** User id **/
    private Long id;

    /** Username **/
    private String username;

    /** Firstname **/
    private String firstName;

    /** Lastname **/
    private String lastName;

    /** User roles/groups **/
    private Set<RoleEntity> authorities;
}
