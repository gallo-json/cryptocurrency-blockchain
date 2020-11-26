package blockchain;

import javax.json.*;

public class JsonUtils {
    public static JsonObject append(JsonObject source, String key, String value) {
        JsonObjectBuilder builder =  Json.createObjectBuilder();
        builder.add(key, value);
        source.entrySet().forEach(e -> builder.add(e.getKey(), e.getValue()));
        return builder.build();
    }
}