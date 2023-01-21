package polszewsky.wineme.app.wine;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polszewsky.wineme.app.common.exceptions.CustomStateException;
import polszewsky.wineme.app.wine.requests.WineFilterObject;

@Service
public class WineService {

    @Autowired
    private WineRepository wineRepository;

    @Transactional
    public Page<Wine> findAll() {
        Pageable pageable = PageRequest.of(0, 25);
        return wineRepository.findAll(pageable);
    }

    @Transactional
    public Wine findById(Integer wineId) {
        return wineRepository.findById(wineId)
                .orElseThrow(() -> new CustomStateException("No wine with ID: " + wineId,
                        HttpStatus.BAD_REQUEST, "NO_WINE_EXISTS"));
    }

    public Page<Wine> findAllByFilters(WineFilterObject filterObject) {
        Pageable pageable = PageRequest.of(filterObject.getPage(), 25);

        return wineRepository.findAllWinesByFilters(filterObject, pageable);
    }
}
