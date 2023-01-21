package polszewsky.wineme.app.wine.criteria_builder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import polszewsky.wineme.app.wine.Wine;
import polszewsky.wineme.app.wine.Wine_;
import polszewsky.wineme.app.wine.requests.WineFilterObject;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WineRepositoryCustomImpl implements WineRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<Wine> findAllWinesByFilters(WineFilterObject filterObject, Pageable pageable) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Wine> query = cb.createQuery(Wine.class);
        Root<Wine> root = query.from(Wine.class);

        List<Predicate> predicates = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();

        orderList.add(cb.asc(root.get(Wine_.name)));

        if (filterObject.getType() != null) {
            predicates.add(cb.like(root.get(Wine_.TYPE.toLowerCase()),
                    "%" + filterObject.getType().toLowerCase() + "%"));
        }

        if (filterObject.getAlcohol() != null) {
            predicates.add(cb.equal(root.get(Wine_.ALCOHOL),
                    filterObject.getAlcohol()));
        }

        if (filterObject.getAcid() != null) {
            predicates.add(cb.equal(root.get(Wine_.ACID),
                    filterObject.getAcid()));
        }

        if (filterObject.getName() != null) {
            predicates.add(cb.like(root.get(Wine_.NAME.toLowerCase()),
                    "%" + filterObject.getName().toLowerCase() + "%"));
        }

        if (filterObject.getBatch() != null) {
            predicates.add(cb.like(root.get(Wine_.BATCH.toLowerCase()),
                    "%" + filterObject.getBatch().toLowerCase() + "%"));
        }

        if (filterObject.getCountry() != null) {
            predicates.add(cb.like(root.get(Wine_.COUNTRY.toLowerCase()),
                    "%" + filterObject.getCountry().toLowerCase() + "%"));
        }

        if (filterObject.getRegion() != null) {
            predicates.add(cb.like(root.get(Wine_.REGION.toLowerCase()),
                    "%" + filterObject.getRegion().toLowerCase() + "%"));
        }

        query.where(predicates.toArray(Predicate[]::new)).orderBy(orderList);

        TypedQuery<Wine> listToFilter = em.createQuery(query);
        long total = listToFilter.getResultList().size();
        listToFilter.setFirstResult((int) pageable.getOffset());
        listToFilter.setMaxResults(pageable.getPageSize());
        List<Wine> events = listToFilter.getResultList();

        return new PageImpl<>(events, pageable, total);
    }
}
