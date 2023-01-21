package polszewsky.wineme.app.wine.criteria_builder;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import polszewsky.wineme.app.wine.Wine;
import polszewsky.wineme.app.wine.requests.WineFilterObject;

public interface WineRepositoryCustom {

    Page<Wine> findAllWinesByFilters(WineFilterObject filterObject, Pageable pageable);
}
