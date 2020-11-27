package blockchain.utils;

import java.io.*;
import java.util.*;
import javax.json.*;
import javax.json.stream.*;

public class JsonUtils {
    public static JsonObject append(JsonObject source, String key, String value) {
        JsonObjectBuilder builder =  Json.createObjectBuilder();
        builder.add(key, value);
        source.entrySet().forEach(e -> builder.add(e.getKey(), e.getValue()));
        return builder.build();
    }

    public static JsonObject append(JsonObject source, String key, JsonObjectBuilder value) {
        JsonObjectBuilder builder =  Json.createObjectBuilder();
        builder.add(key, value);
        source.entrySet().forEach(e -> builder.add(e.getKey(), e.getValue()));
        return builder.build();
    }

    public static String toString(JsonObject jsonObj) {
        StringWriter sw = new StringWriter();

        try {
            Map<String, Object> map = new HashMap<>();
            map.put(JsonGenerator.PRETTY_PRINTING, true);
            JsonWriterFactory writerFactory = Json.createWriterFactory(map);
            JsonWriter jsonWriter = writerFactory.createWriter(sw);
            jsonWriter.writeObject(jsonObj);
            jsonWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sw.toString();
    }
}