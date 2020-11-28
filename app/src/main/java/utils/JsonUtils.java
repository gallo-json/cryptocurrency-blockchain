package blockchain.utils;

import java.io.*;
import java.util.*;
import javax.json.*;
import javax.json.stream.*;
import java.text.*;

import blockchain.core.*;

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


    public static Block toBlock(JsonObject jsonBlock) throws Exception {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        byte[] previousHash = HashUtils.toByteArray(jsonBlock.getJsonObject("block").getString("previous hash"));
        byte[] hash = HashUtils.toByteArray(jsonBlock.getJsonObject("block").getString("hash"));
        int nonce = Integer.valueOf(jsonBlock.getJsonObject("block").getString("nonce"));

        JsonObject transactionsJson = jsonBlock.getJsonObject("block").getJsonObject("transactions");

        for (int i = 1; i <= transactionsJson.size(); i++) {
            JsonObject currentTransaction = transactionsJson.getJsonObject("transaction " + Integer.valueOf(i));

            DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
            Date date =  df.parse(currentTransaction.getString("time stamp"));  

            transactions.add(new Transaction(Integer.valueOf(currentTransaction.getString("amount")), currentTransaction.getString("sender"),
                                            currentTransaction.getString("receiver"), date));
        }

        return new Block(transactions, previousHash, hash, nonce);
    }

}