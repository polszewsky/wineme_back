package polszewsky.wineme.app.wine_discussion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polszewsky.wineme.app.administration.users.User;
import polszewsky.wineme.app.common.db_utils.CreatedEditedAt;
import polszewsky.wineme.app.common.exceptions.CustomStateException;
import polszewsky.wineme.app.common.security.session.SessionService;
import polszewsky.wineme.app.wine.Wine;
import polszewsky.wineme.app.wine.WineService;
import polszewsky.wineme.app.wine_discussion.requests.WineDiscussionRequest;

@Service
public class WineDiscussionService {

    @Autowired
    private WineDiscussionRepository wineDiscussionRepository;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private WineService wineService;

    @Transactional
    public WineDiscussion findById(Integer id) {
        return wineDiscussionRepository.findById(id).orElseThrow(() ->
                new CustomStateException("", HttpStatus.BAD_REQUEST, "NO_DISCUSSION_EXISTS"));
    }

    @Transactional
    public WineDiscussion createEntry(WineDiscussionRequest discussionRequest) {
        User user = sessionService.getUser();
        Wine wine = wineService.findById(discussionRequest.getId());

        WineDiscussion discussion = WineDiscussion.builder()
                .user(user)
                .wine(wine)
                .comment(discussionRequest.getComment())
                .createdEditedAt(new CreatedEditedAt())
                .build();

        return wineDiscussionRepository.save(discussion);
    }

    @Transactional
    public WineDiscussion updateEntry(WineDiscussionRequest discussionRequest) {
        WineDiscussion discussion = findById(discussionRequest.getId());

        sessionService.validateLoggedUser(discussion.getUser().getId());

        discussion.setComment(discussion.getComment());
        discussion.getCreatedEditedAt().updateEditedAt();

        return wineDiscussionRepository.save(discussion);
    }

    @Transactional
    public boolean deleteEntry(Integer id) {
        WineDiscussion discussion = findById(id);

        sessionService.validateLoggedUser(discussion.getUser().getId());

        wineDiscussionRepository.delete(discussion);
        return true;
    }
}
