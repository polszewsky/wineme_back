package polszewsky.wineme.app.wine_discussion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import polszewsky.wineme.app.common.db_utils.CreatedEditedAt;
import polszewsky.wineme.app.wine_discussion.WineDiscussion;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WineDiscussionDto {

    private Integer id;
    private Integer wineId;
    private Long userId;
    private String comment;
    private CreatedEditedAt createdEditedAt;

    public WineDiscussionDto(WineDiscussion other) {
        this.id = other.getId();
        this.wineId = other.getWine().getId();
        this.userId = other.getUser().getId();
        this.comment = other.getComment();
        this.createdEditedAt = other.getCreatedEditedAt();
    }


}
