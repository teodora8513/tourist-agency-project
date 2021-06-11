package rs.ac.bg.fon.naprednajava.touristagency.entity.authority;

import lombok.Data;

@Data
public class UserDto {

    /** User id **/
    private Long id;

    /** Username **/
    private String username;

    /** Firstname **/
    private String firstName;

    /** Lastname **/
    private String lastName;

}
