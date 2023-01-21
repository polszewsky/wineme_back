package polszewsky.wineme.app.wine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import polszewsky.wineme.app.wine.Wine;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WineSimpleDto {

    private Integer id;
    private String type;
    private Double alcohol;
    private Integer acid;
    private String name;
    private String batch;
    private String country;
    private String region;

    public WineSimpleDto(Wine wine) {
        this.id = wine.getId();
        this.type = wine.getType();
        this.alcohol = wine.getAlcohol();
        this.acid = wine.getAcid();
        this.name = wine.getName();
        this.batch = wine.getBatch();
        this.country = wine.getCountry();
        this.region = wine.getRegion();
    }
}
