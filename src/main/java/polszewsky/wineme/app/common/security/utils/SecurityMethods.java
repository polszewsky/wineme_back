package polszewsky.wineme.app.common.security.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Component;
import polszewsky.wineme.app.administration.privlge.Privilege;
import polszewsky.wineme.app.administration.users.UserRepository;
import polszewsky.wineme.app.common.security.MyUserDetails;
import polszewsky.wineme.app.common.security.session.SessionService;

import java.util.ArrayList;
import java.util.List;

@Component
@Configuration
@EnableMethodSecurity
public class SecurityMethods {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionService sessionService;

    public boolean hasRight(String privilegeSymbol) {
        MyUserDetails userDetails = sessionService.getLoggedUserDetails();
        List<Privilege> privileges = new ArrayList<>();

        userDetails.getRoles().forEach(role -> privileges.addAll(role.getPrivileges()));

        return privileges.stream().anyMatch(privilege -> privilege.getName().equals(privilegeSymbol));
    }
}
