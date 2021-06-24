package rs.ac.bg.fon.naprednajava.touristagency.requests.authority;

import rs.ac.bg.fon.naprednajava.touristagency.dto.MyDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Base user requests
 * @author mdjukanovic
 */
public abstract class BaseUserRequest implements MyDto {

    /** Username **/
    @NotBlank @Email
    private String username;

    /** Password **/
    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
