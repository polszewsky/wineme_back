package polszewsky.wineme.app.common.security.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import polszewsky.wineme.app.administration.users.User;
import polszewsky.wineme.app.administration.users.UserService;
import polszewsky.wineme.app.common.exceptions.CustomStateException;
import polszewsky.wineme.app.common.security.MyUserDetails;


@Service
public class SessionService {

    @Autowired
    private UserService userService;

    public MyUserDetails getLoggedUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object user = (authentication != null) ? authentication.getPrincipal() : null;
        if (user instanceof MyUserDetails) {
            return (MyUserDetails) user;
        } else {
            throw new RuntimeException();
        }
    }

    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uniqueName = authentication.getName();

        return userService.findByEmail(uniqueName);
    }

    public void validateLoggedUser(Long id) {
        MyUserDetails loggedUser = getLoggedUserDetails();

        if (!loggedUser.getId().equals(id)) {
            throw new CustomStateException("INCOMPATIBLE_USER", HttpStatus.BAD_REQUEST, "INCOMPATIBLE_USER");
        }
    }

}
