package polszewsky.wineme.app.user_wine;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import polszewsky.wineme.app.user_wine.dto.UserWineDto;

import java.io.IOException;

public class UserWineSerializer extends JsonSerializer<UserWine> {
    @Override
    public void serialize(UserWine userWine, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(new UserWineDto(userWine));
    }
}
