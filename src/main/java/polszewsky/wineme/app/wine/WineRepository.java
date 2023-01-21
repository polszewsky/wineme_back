package polszewsky.wineme.app.wine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import polszewsky.wineme.app.wine.criteria_builder.WineRepositoryCustom;

@RepositoryRestResource(exported = false)
public interface WineRepository extends JpaRepository<Wine, Integer>, WineRepositoryCustom {

}
