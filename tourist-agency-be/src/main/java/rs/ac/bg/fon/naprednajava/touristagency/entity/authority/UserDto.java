package rs.ac.bg.fon.naprednajava.touristagency.entity.authority;

import rs.ac.bg.fon.naprednajava.touristagency.dto.MyDto;
import rs.ac.bg.fon.naprednajava.touristagency.dto.ReservationDto;
import rs.ac.bg.fon.naprednajava.touristagency.entity.ReservationEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    
    private Set<ReservationEntity> reservations = new HashSet<>();


    public Set<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(Set<ReservationEntity> reservations) {
        this.reservations = reservations;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<RoleEntity> getAuthorities() {
        return authorities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAuthorities(Set<RoleEntity> authorities) {
        this.authorities = authorities;
    }
    
}
