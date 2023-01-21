package polszewsky.wineme.app.user_account.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDetailsRequest {

    @NotNull
    private Integer id;
    @NotNull
    private String firstName;

    private String password;
    private String email;

}
