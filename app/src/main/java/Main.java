package blockchain;

import javax.json.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to be a miner or a full node? (m / f)");
        char choice = scanner.next().charAt(0);

        if (choice == 'm') {
            Miner miner = new Miner(3000, "jose", false);
            miner.start();
        }
        else if (choice == 'f') {
            FullNode fullNode = new FullNode(3001, "full node", true);
        }

    }
}