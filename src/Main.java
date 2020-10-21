import java.util.Date;
import java.util.Scanner;
import java.security.KeyPair;

public class Main {
    public static void main(String[] args) {
        try {
            Blockchain pepegaCoin = new Blockchain();
            SigningKeys signingKeys = new SigningKeys();
            Scanner input = new Scanner(System.in);

            System.out.println("Your designated public and private keys. Do not share your private key with anyone!");
            KeyPair myKeys = signingKeys.generate();

            System.out.println();
    
            String myWalletAddress = signingKeys.toString(myKeys.getPublic());
            
            System.out.println("Creating transaction...");
            System.out.println("Sender: " + myWalletAddress + " (this is your address)");
            System.out.print("Reciever: "); String receiver = input.nextLine();
            System.out.print("Amount: "); int amount = input.nextInt();

            System.out.print("Sign transaction? (y/n): "); char isSign = input.next().charAt(0);
            if (isSign == 'y') {
                Transaction tx = new Transaction(amount, myWalletAddress, receiver);
                tx.signTransaction(signingKeys, myKeys);
                tx.printAsString();
                
            }

            /*
            Blockchain pepegaCoin = new Blockchain();
            SigningKeys signingKeys = new SigningKeys();
            KeyPair myKeys = signingKeys.generate();
            String myWalletAddress = signingKeys.toString(myKeys.getPublic());

            Transaction tx1 = new Transaction(10, myWalletAddress, "reciever public key");
            tx1.signTransaction(signingKeys, myKeys);
            pepegaCoin.addTransaction(tx1);

            System.out.println("Starting the miner...");
            pepegaCoin.minePendingTransactions(myWalletAddress);

            System.out.println("Balance of the miner is now " + pepegaCoin.getBalance(myWalletAddress));
            System.out.println("Is chain valid: " + pepegaCoin.isChainValid());
            */
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}