package polszewsky.wineme.app.administration.users.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import polszewsky.wineme.app.administration.users.User;

import java.io.IOException;

public class UserSerializer extends JsonSerializer<User> {
    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(new UserDto(user));
    }
}
