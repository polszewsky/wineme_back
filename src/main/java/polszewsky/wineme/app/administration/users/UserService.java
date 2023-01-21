package polszewsky.wineme.app.administration.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polszewsky.wineme.app.administration.roles.RoleRepository;
import polszewsky.wineme.app.common.enums.SubscriptionLevelEnum;
import polszewsky.wineme.app.common.exceptions.CustomStateException;
import polszewsky.wineme.app.common.exceptions.EmailExistsException;
import polszewsky.wineme.app.user_account.requests.UserDetailsRequest;

import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new CustomStateException("No user within id", HttpStatus.BAD_REQUEST, "NO_USER"));
    }

    @Transactional
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new CustomStateException("No user within email", HttpStatus.BAD_REQUEST, "NO_USER"));
    }

    @Transactional
    public User registerNewUserAccount(UserDetailsRequest accountDto) throws EmailExistsException {

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException
                    ("There is an account with that email adress: " + accountDto.getEmail());
        }
        User user = new User();

        user.setFirstName(accountDto.getFirstName());
        user.setPasswordAndEncode(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        user.setSubscription(SubscriptionLevelEnum.USER_BASIC);
        user.setRoles(Arrays.asList(roleRepository.findByName("USER_BASIC")));

        return userRepository.save(user);
    }


    private boolean emailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }


    public void save(User user) {
        userRepository.save(user);
    }
}
