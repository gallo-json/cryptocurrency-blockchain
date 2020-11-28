package blockchain;

import javax.json.*;
import java.util.Scanner;
import java.net.InetAddress;

import blockchain.utils.*;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        Scanner scanner = new Scanner(System.in);
        String name = InetAddress.getLocalHost().getHostName();
        System.out.println("Do you want to be a miner or a full node? (m / f)");
        char choice = scanner.next().charAt(0);

        if (choice == 'm') {
            Miner miner = new Miner(name, true);
            miner.start();
        }
        else if (choice == 'f') {
            FullNode fullNode = new FullNode(name, true);
        }
        */
        JsonObject data = Json.createObjectBuilder()
            .add("miner", "jose")
            .add("block", Json.createObjectBuilder()
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
                .add("nonce", "1342"))
        .build();

        System.out.println(JsonUtils.toString(data));
    }
}