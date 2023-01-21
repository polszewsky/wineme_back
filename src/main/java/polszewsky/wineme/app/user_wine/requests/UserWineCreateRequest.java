package polszewsky.wineme.app.user_wine.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserWineCreateRequest {

    //Optional for existing wine
    private Integer wineId;

    private Integer body;
    private Integer hue;
    private Integer year;
    private String review;
    private Integer score;
}
