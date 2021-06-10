package rs.ac.bg.fon.naprednajava.touristagency.entity.authority;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity{

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

    @Column(name = "last_name", nullable = false)
    @Getter @Setter
    private String lastName;
}
