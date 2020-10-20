import java.util.Date;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Transaction> sampleTransactions = new ArrayList<Transaction>();
        sampleTransactions.add(new Transaction(10, "Tarek", "Jose"));
        sampleTransactions.add(new Transaction(2, "Jose", "Tarek"));

        Blockchain pepegaCoin = new Blockchain();
        pepegaCoin.createTransaction(new Transaction(10, "jose", "tarek"));
        pepegaCoin.createTransaction(new Transaction(2, "tarek", "jose"));
        pepegaCoin.printAsString();

        System.out.println("mining block...");
        pepegaCoin.minePendingTransactions("Sergei");

        System.out.println("Sergei (miner) balance: " + pepegaCoin.getBalance("Sergei"));

        Key.generateKeys();
    }
}