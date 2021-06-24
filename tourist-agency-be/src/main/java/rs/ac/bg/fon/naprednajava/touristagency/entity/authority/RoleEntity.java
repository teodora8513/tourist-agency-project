package rs.ac.bg.fon.naprednajava.touristagency.entity.authority;

import org.springframework.security.core.GrantedAuthority;
import rs.ac.bg.fon.naprednajava.touristagency.entity.MyEntity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity implements GrantedAuthority, MyEntity {

    public RoleEntity() {
    }

    public RoleEntity(Long id, String authority, String displayName) {
        this.id = id;
        this.authority = authority;
        this.displayName = displayName;
    }

    /** Role ID **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Authority **/
    @Column(nullable = false, unique = true)
    private String authority;

    /** Display name of role **/
    @Column(nullable = false, unique = true)
    private String displayName;

    public Long getId() {
        return id;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
