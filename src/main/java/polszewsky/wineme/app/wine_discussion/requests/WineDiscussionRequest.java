package polszewsky.wineme.app.wine_discussion.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WineDiscussionRequest {

    @NotNull
    private Integer id;

    @NotNull
    private String comment;
}
