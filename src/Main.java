import java.util.Date;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Blockchain pepegaCoin = new Blockchain();

        SigningKeys myKeys = new SigningKeys();
        String myWalletAddress = myKeys.getPublicKeyString();
        System.out.println("Your public key is: " + myWalletAddress);
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
    }
}