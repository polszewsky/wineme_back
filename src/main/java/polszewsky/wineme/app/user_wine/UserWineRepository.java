package polszewsky.wineme.app.user_wine;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import polszewsky.wineme.app.administration.users.User;

import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface UserWineRepository extends JpaRepository<UserWine, Integer> {

    @Query("select uw from UserWine uw where uw.id = ?1 and uw.user = ?2")
    Optional<UserWine> findById(Integer wineId, User user);

    Page<UserWine> findAllByUser(User user, Pageable pageable);
}
