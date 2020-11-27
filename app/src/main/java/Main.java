package blockchain;

import javax.json.*;
import java.util.Scanner;
import java.net.InetAddress;

import blockchain.utils.HashUtils;

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
        String string = "hello";
        byte[] sha = HashUtils.getSHA("hello");

        for (byte b : sha) {
            System.out.print(b);
        }
        System.out.println();

        String shaHex = HashUtils.toHexString(sha);
        System.out.println(shaHex);

        byte[] backToSha = HashUtils.toByteArray(shaHex);

        for (byte b : backToSha) {
            System.out.print(b);
        }

    }
}