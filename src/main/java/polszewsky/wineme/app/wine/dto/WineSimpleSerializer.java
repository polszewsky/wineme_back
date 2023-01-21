package polszewsky.wineme.app.wine.dto;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import polszewsky.wineme.app.wine.Wine;

import java.io.IOException;

public class WineSimpleSerializer extends JsonSerializer<Wine> {

    @Override
    public void serialize(Wine wine, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(new WineSimpleDto(wine));
    }
}
