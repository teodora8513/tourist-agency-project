package rs.ac.bg.fon.naprednajava.touristagency.entity.authority;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import rs.ac.bg.fon.naprednajava.touristagency.entity.MyEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity implements UserDetails, MyEntity {

    /** User id **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    /** User username **/
    @Column(nullable = false)
    @Setter
    private String username;

    /** User lastname **/
    @Column(nullable = false)
    @Getter @Setter
    private String password;

    /** User firstname **/
    @Column(name = "first_name", nullable = false)
    @Getter @Setter
    private String firstName;

    /** User lastname **/
    @Column(name = "last_name", nullable = false)
    @Getter @Setter
    private String lastName;

    /** User authorities/roles **/
    @ManyToMany(fetch = FetchType.EAGER)
    @Setter
    private Set<RoleEntity> authorities = new HashSet<>();

    /** Flag whether user is enabled **/
    @Setter
    private boolean enabled = true;

    /** Methods from the implemented interface **/

    /**
     * Checks for user roles/groups
     * @return User roles/gorups
     */
    @Override
    public Collection<RoleEntity> getAuthorities() {
        return this.authorities;
    }

    /**
     * Getter for username
     * @return username
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * Checks if the user account is still active
     * @return true if it is active, false otherwise
     */
    @Override
    public boolean isAccountNonExpired() {
        return this.enabled;
    }

    /**
     * Checks if the user account is non locked
     * @return true if its non locked, false otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return this.enabled;
    }

    /**
     * Checks if user credentials are valid
     * @return true if they are valid, false otherwise
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return this.enabled;
    }

    /**
     * Checks if the user account is active, enabled
     * @return true if it is enabled, false otherwise
     */
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
