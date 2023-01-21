package polszewsky.wineme.app.user_wine.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserWineUpdateRequest {

    @NotNull
    private Integer id;

    @NotNull
    private Integer year;

    @NotNull
    private String review;

    @NotNull
    private Integer score;

}
