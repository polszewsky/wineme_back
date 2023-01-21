package polszewsky.wineme.app.user_account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polszewsky.wineme.app.administration.roles.Role;
import polszewsky.wineme.app.administration.roles.RoleService;
import polszewsky.wineme.app.administration.users.User;
import polszewsky.wineme.app.administration.users.UserService;
import polszewsky.wineme.app.common.exceptions.CustomStateException;
import polszewsky.wineme.app.common.exceptions.EmailExistsException;
import polszewsky.wineme.app.common.security.session.SessionService;
import polszewsky.wineme.app.user_account.requests.UserDetailsRequest;
import polszewsky.wineme.app.user_account.requests.UserSubscriptionRequest;

@Service
@Slf4j
public class AccountService {

    @Autowired
    private UserService userService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private RoleService roleService;


    @Transactional
    public boolean updateUserDetails(UserDetailsRequest detailsRequest) {
        User user = userService.findById(detailsRequest.getId());
        sessionService.validateLoggedUser(user.getId());

        user.setFirstName(detailsRequest.getFirstName());

        userService.save(user);
        log.info("Updated User details for User: " + user.getId());
        return true;
    }

    @Transactional
    public boolean changePassword(UserDetailsRequest detailsRequest) {
        User user = userService.findById(detailsRequest.getId());

        User loggedUser = sessionService.getUser();
        boolean passMatches = loggedUser.passwordMatcher(detailsRequest.getPassword());
        if (!passMatches) {
            throw new CustomStateException("Previous password does not match", HttpStatus.BAD_REQUEST, "PASSWORD_MATCH_ERROR");
        }

        user.setPasswordAndEncode(detailsRequest.getPassword());
        userService.save(user);
        log.info("Updated User password for User: " + user.getId());
        return true;
    }


    @Transactional
    public boolean updateSubscription(UserSubscriptionRequest subscriptionRequest) {
        User user = userService.findById(subscriptionRequest.getId());
        sessionService.validateLoggedUser(user.getId());

        Role roleToDelete = roleService.findByName(user.getSubscription().name());
        user.getRoles().remove(roleToDelete);

        Role roleToAdd = roleService.findByName(subscriptionRequest.getSubscription().name());
        user.getRoles().add(roleToAdd);

        userService.save(user);
        log.info("Updated User subscription for User: " + user.getId());
        return true;
    }

    @Transactional
    public boolean registerNewUserAccount(UserDetailsRequest userRequest) {

        User user;

        try {
            user = userService.registerNewUserAccount(userRequest);
        } catch (EmailExistsException e) {
            throw new CustomStateException("Cannot create user: Email exists", HttpStatus.BAD_REQUEST, "EMAIL_MATCH_ERROR");
        }

        //TODO: Mock Email Sender

        log.info("Registered new User. Sending confirmation email... {}", user);

        return true;
    }
}
