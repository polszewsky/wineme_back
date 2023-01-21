package polszewsky.wineme.app.wine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import polszewsky.wineme.app.common.db_utils.CreatedEditedAt;
import polszewsky.wineme.app.wine.Wine;
import polszewsky.wineme.app.wine_discussion.WineDiscussion;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WineDto {

    private Integer id;
    private String type;
    private Double alcohol;
    private Integer acid;
    private String name;
    private String batch;
    private String country;
    private String region;
    private List<WineDiscussion> discussions;
    private CreatedEditedAt createdEditedAt;

    public WineDto(Wine wine) {
        this.id = wine.getId();
        this.type = wine.getType();
        this.alcohol = wine.getAlcohol();
        this.acid = wine.getAcid();
        this.name = wine.getName();
        this.batch = wine.getBatch();
        this.country = wine.getCountry();
        this.region = wine.getRegion();
        this.discussions = wine.getDiscussions();
        this.createdEditedAt = wine.getCreatedEditedAt();
    }
}
