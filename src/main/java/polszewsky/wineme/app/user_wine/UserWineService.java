package polszewsky.wineme.app.user_wine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polszewsky.wineme.app.administration.users.User;
import polszewsky.wineme.app.common.db_utils.CreatedEditedAt;
import polszewsky.wineme.app.common.exceptions.CustomStateException;
import polszewsky.wineme.app.common.security.session.SessionService;
import polszewsky.wineme.app.user_wine.requests.UserWineCreateRequest;
import polszewsky.wineme.app.user_wine.requests.UserWineUpdateRequest;
import polszewsky.wineme.app.wine.Wine;
import polszewsky.wineme.app.wine.WineService;

import static polszewsky.wineme.app.wine.utils.WineUtils.fillWineDetails;

@Service
@Slf4j
public class UserWineService {

    @Autowired
    private WineService wineService;
    @Autowired
    private UserWineRepository userWineRepository;
    @Autowired
    private SessionService sessionService;

    @Transactional
    public Page<UserWine> findAll() {
        User user = sessionService.getUser();

        Pageable pageable = PageRequest.of(0, 25);
        return userWineRepository.findAllByUser(user, pageable);
    }

    @Transactional
    public UserWine findById(Integer wineId) {
        User user = sessionService.getUser();

        return userWineRepository.findById(wineId, user).orElseThrow(() ->
                new CustomStateException("No wine with ID: " + wineId, HttpStatus.BAD_REQUEST, "NO_WINE_EXISTS"));
    }

    @Transactional
    public UserWine addWine(UserWineCreateRequest createRequest) {
        User user = sessionService.getUser();
        Wine wine = new Wine();

        if (createRequest.getWineId() != null)
            wine = wineService.findById(createRequest.getWineId());

        if (wine.isNull()) wine = fillWineDetails(createRequest);

        UserWine userWine = UserWine.builder()
                .user(user)
                .wine(wine)
                .hue(createRequest.getHue())
                .body(createRequest.getBody())
                .review(createRequest.getReview())
                .year(createRequest.getYear())
                .score(createRequest.getScore())
                .createdEditedAt(new CreatedEditedAt())
                .build();

        userWineRepository.save(userWine);
        log.info("Created new Wine for User, {}", userWine);
        return userWine;
    }

    @Transactional
    public UserWine updateWine(UserWineUpdateRequest updateRequest) {
        UserWine userWine = findById(updateRequest.getId());

        userWine.setYear(updateRequest.getYear());
        userWine.setReview(updateRequest.getReview());
        userWine.setScore(updateRequest.getScore());

        userWine.getCreatedEditedAt().updateEditedAt();

        userWineRepository.save(userWine);
        log.info("Updated  Wine for User, {}", userWine);
        return userWine;
    }

    @Transactional
    public boolean deleteWine(Integer wineId) {
        UserWine userWine = findById(wineId);

        userWineRepository.delete(userWine);
        return true;
    }
}
