package blockchain;

import network.Peer;
import javax.json.*;

public class Main {
    public static void main(String[] args) throws Exception{
        JsonObject data = Json.createObjectBuilder()
        .add("transactions", Json.createObjectBuilder()
            .add("transaction 1", Json.createObjectBuilder()
                .add("amount", "100")
                .add("sender", "system")
                .add("receiver", "jose")
                .add("time stamp", "nov 27 2020"))
            .add("transaction 2", Json.createObjectBuilder()
                .add("amount", "8")
                .add("sender", "jose")
                .add("receiver", "juan")
                .add("time stamp", "Nov 28 2020")))
        .add("previous hash", "slalakjkldfjklajkl00")
        .add("hash", "sa;dkakskdkkksa")
        .add("nonce", "1342")
    .build();

        Peer peer = new Peer();

        Thread.sleep(30000);

        peer.send(data);

    }
}