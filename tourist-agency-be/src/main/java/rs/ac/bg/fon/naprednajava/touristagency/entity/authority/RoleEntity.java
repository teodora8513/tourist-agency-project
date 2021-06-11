package rs.ac.bg.fon.naprednajava.touristagency.entity.authority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Table(name = "roles")
public class RoleEntity  {

    /** Role ID **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    /** Authority **/
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String authority;

    /** Display name of role **/
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String displayName;

}
