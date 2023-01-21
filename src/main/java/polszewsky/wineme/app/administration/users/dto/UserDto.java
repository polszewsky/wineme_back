package polszewsky.wineme.app.administration.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import polszewsky.wineme.app.administration.users.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private Long id;
    private String firstName;
    private boolean enabled = true;
    private boolean tokenExpired = false;

    public UserDto(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
    }
}
