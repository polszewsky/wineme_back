package polszewsky.wineme.app.administration.roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String role_user);
}
