package rs.ac.bg.fon.naprednajava.touristagency.requests.authority;

import rs.ac.bg.fon.naprednajava.touristagency.dto.ReservationDto;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    private Set<ReservationDto> reservations = new HashSet<>();

    public String getRePassword() {
        return rePassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<ReservationDto> getReservations() {
        return reservations;
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

    public void setReservations(Set<ReservationDto> reservations) {
        this.reservations = reservations;
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
