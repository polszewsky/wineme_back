package polszewsky.wineme.app.wine.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WineFilterObject {

    private String type;
    private Double alcohol;
    private Integer acid;
    private String name;
    private String batch;
    private String country;
    private String region;

    //Pageable
    private Integer page = 0;

    //User Input
    private Integer year;
}
