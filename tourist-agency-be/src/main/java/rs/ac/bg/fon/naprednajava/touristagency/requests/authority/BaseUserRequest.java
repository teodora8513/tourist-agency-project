package rs.ac.bg.fon.naprednajava.touristagency.requests.authority;

import lombok.Data;
import rs.ac.bg.fon.naprednajava.touristagency.dto.MyDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Base user requests
 * @author mdjukanovic
 */
@Data
public abstract class BaseUserRequest implements MyDto {

    /** Username **/
    @NotBlank @Email
    private String username;

    /** Password **/
    @NotBlank
    private String password;
}
