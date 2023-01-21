package polszewsky.wineme.app.wine_discussion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;
import polszewsky.wineme.app.administration.users.User;
import polszewsky.wineme.app.common.db_utils.CreatedEditedAt;
import polszewsky.wineme.app.wine.Wine;
import polszewsky.wineme.app.wine_discussion.dto.WineDiscussionSerializer;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonSerialize(using = WineDiscussionSerializer.class)
public class WineDiscussion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_wine", nullable = false)
    private Wine wine;

    @ToString.Exclude
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    private String comment;

    @Embedded
    private CreatedEditedAt createdEditedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WineDiscussion)) return false;
        WineDiscussion that = (WineDiscussion) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
