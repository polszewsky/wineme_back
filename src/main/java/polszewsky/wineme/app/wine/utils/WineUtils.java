package polszewsky.wineme.app.wine.utils;

import org.springframework.stereotype.Component;
import polszewsky.wineme.app.user_wine.requests.UserWineCreateRequest;
import polszewsky.wineme.app.wine.Wine;

@Component
public class WineUtils {

    public static Wine fillWineDetails(UserWineCreateRequest createRequest){
        return new Wine();
    }
}
