package rs.ac.bg.fon.naprednajava.touristagency.requests.authority;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

/**
 * Create user request
 * @author mdjukanovic
 */
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

    public String getRePassword() {
        return rePassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateUserRequest that = (CreateUserRequest) o;
        return Objects.equals(rePassword, that.rePassword) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rePassword, firstName, lastName);
    }
}
