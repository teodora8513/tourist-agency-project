package rs.ac.bg.fon.naprednajava.touristagency.requests.authority;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * Create user request
 * @author mdjukanovic
 */
@Data
@EqualsAndHashCode
public class CreateUserRequest extends BaseUserRequest{

    /** Repeated password **/
    @NotBlank
    private String rePassword;

    /** First name **/
    @NotBlank
    private String firstName;

    /** Last Name **/
    @NotBlank
    private String lastName;
}
