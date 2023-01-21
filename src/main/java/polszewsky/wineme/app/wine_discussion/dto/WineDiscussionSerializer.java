package polszewsky.wineme.app.wine_discussion.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import polszewsky.wineme.app.wine_discussion.WineDiscussion;

import java.io.IOException;

public class WineDiscussionSerializer extends JsonSerializer<WineDiscussion> {
    @Override
    public void serialize(WineDiscussion discussion, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(new WineDiscussionDto(discussion));
    }
}
