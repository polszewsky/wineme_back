package polszewsky.wineme.app.administration.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import polszewsky.wineme.app.administration.roles.Role;
import polszewsky.wineme.app.common.enums.SubscriptionLevelEnum;

import java.util.Collection;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "adm_user")
@Builder
public class User {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "email", nullable = false)
    private String email;

    private SubscriptionLevelEnum subscription;

    @ToString.Exclude
    @JsonIgnore
    private String password;


    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;


    public void setPasswordAndEncode(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public User(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.subscription = user.getSubscription();
        this.roles = user.getRoles();
    }

    public boolean passwordMatcher(String oldPassword) {
        return PASSWORD_ENCODER.matches(oldPassword, this.password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        User that = (User) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
