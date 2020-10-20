import java.util.Date;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Transaction> sampleTransactions = new ArrayList<Transaction>();
        sampleTransactions.add(new Transaction(10, "Tarek", "Jose", new Date()));
        sampleTransactions.add(new Transaction(2, "Jose", "Tarek", new Date()));

        Blockchain pepegaCoin = new Blockchain();
        pepegaCoin.addBlock(sampleTransactions);
        pepegaCoin.printAsString();
    }
}