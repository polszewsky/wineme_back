package polszewsky.wineme.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import polszewsky.wineme.app.administration.users.User;
import polszewsky.wineme.app.administration.users.UserRepository;
import polszewsky.wineme.app.administration.users.UserService;
import polszewsky.wineme.app.common.enums.SubscriptionLevelEnum;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserManagementTests {

    @Mock
    private UserService userService;

    @Test
    void savedUserHasRegistrationDate() {
        User user = new User(2L, "Peter", "test@test.com", SubscriptionLevelEnum.USER_BASIC, "password", new ArrayList<>());

        when(userService.findByEmail("test@test.com")).thenReturn(user);

        //test
        User testUser = userService.findByEmail("test@test.com");

        assertEquals(2, testUser.getId());
        assertEquals("test@test.com", testUser.getEmail());
    }
}
