package polszewsky.wineme.app.user_wine.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import polszewsky.wineme.app.administration.users.User;
import polszewsky.wineme.app.administration.users.dto.UserSerializer;
import polszewsky.wineme.app.common.db_utils.CreatedEditedAt;
import polszewsky.wineme.app.user_wine.UserWine;
import polszewsky.wineme.app.wine.Wine;
import polszewsky.wineme.app.wine.dto.WineSimpleSerializer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWineDto {

    private Integer id;
    @JsonSerialize(using = UserSerializer.class)
    private User user;
    @JsonSerialize(using = WineSimpleSerializer.class)
    private Wine wine;
    private Integer body;
    private Integer hue;
    private Integer year;
    private String review;
    private Integer score;
    private CreatedEditedAt createdEditedAt;

    public UserWineDto(UserWine userWine) {
        this.id = userWine.getId();
        this.user = userWine.getUser();
        this.wine = userWine.getWine();
        this.body = userWine.getBody();
        this.hue = userWine.getHue();
        this.year = userWine.getYear();
        this.review = userWine.getReview();
        this.score = userWine.getScore();
        this.createdEditedAt = userWine.getCreatedEditedAt();
    }
}
