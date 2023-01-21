package polszewsky.wineme.app.common.db_utils;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedEditedAt {

    private LocalDateTime createdAt;
    private LocalDateTime editedAt;

    public void updateEditedAt() {
        this.editedAt = LocalDateTime.now();
    }
}
