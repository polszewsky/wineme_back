package polszewsky.wineme.app.user_account.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import polszewsky.wineme.app.common.enums.SubscriptionLevelEnum;

@Data
@NoArgsConstructor
public class UserSubscriptionRequest {

    @NotNull
    private Integer id;
    @NotNull
    private SubscriptionLevelEnum subscription;
}
