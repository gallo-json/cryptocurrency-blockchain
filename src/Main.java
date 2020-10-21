import java.util.Date;
import java.util.ArrayList;
import java.security.KeyPair;

public class Main {
    public static void main(String[] args) {
        try {
            Blockchain pepegaCoin = new Blockchain();
            SigningKeys signingKeys = new SigningKeys();
            KeyPair myKeys = signingKeys.generate();
            String myWalletAddress = signingKeys.toString(myKeys.getPublic());

            Transaction tx1 = new Transaction(10, myWalletAddress, "reciever public key");
            tx1.signTransaction(signingKeys, myKeys);
            pepegaCoin.addTransaction(tx1);
            pepegaCoin.printAsString();

            System.out.println("Starting the miner...");
            pepegaCoin.minePendingTransactions(myWalletAddress);

            System.out.println("Balance of the miner is now " + pepegaCoin.getBalance(myWalletAddress));
        } catch (Exception e) {
            System.out.println(e);
        }

        /*
        try {
            SigningKeys signingKeys = new SigningKeys();
            KeyPair myKeys = signingKeys.generate();

            String[] obj = signingKeys.sign("nice cock", myKeys);
            System.out.println(signingKeys.received(obj));

        } catch (Exception e) {
            System.out.println(e);
        }
        */
        /*
        try {
            Transaction tx1 = new Transaction(10, myWalletAddress, "reciever public key");
            tx1.signTransaction(myKeys);
            pepegaCoin.addTransaction(tx1);

            System.out.println("Starting the miner...");
            pepegaCoin.minePendingTransactions(myWalletAddress);

            System.out.println("Balance of the miner is now " + pepegaCoin.getBalance(myWalletAddress));
        } catch (Exception e) {
            System.out.println(e);
        }
        */
    }
}