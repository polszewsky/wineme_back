package polszewsky.wineme.app.wine;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;
import polszewsky.wineme.app.common.db_utils.CreatedEditedAt;
import polszewsky.wineme.app.wine.dto.WineSerializer;
import polszewsky.wineme.app.wine_discussion.WineDiscussion;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonSerialize(using = WineSerializer.class)
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String type;
    private Double alcohol;
    private Integer acid;
    private String name;
    private String batch;
    private String country;
    private String region;

    @OneToMany(mappedBy = "wine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WineDiscussion> discussions;

    @Embedded
    private CreatedEditedAt createdEditedAt;

    public Boolean isNull() {
        return this.id != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wine)) return false;
        Wine that = (Wine) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}