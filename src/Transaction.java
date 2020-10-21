import java.util.Date;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public class Transaction {
    private int amount;
    private String sender;
    private String reciever;
    private Date date = new Date();
    private String signature;

    public Transaction(int amount, String sender, String reciever) {
        this.amount = amount; 
        this.sender = sender;
        this.reciever = reciever;
    }

    public byte[] calculateHash() throws NoSuchAlgorithmException {
        return Hash.getSHA(sender + reciever + amount);
    }
    /*

    public void signTransaction(SigningKeys signingKeys) throws SignatureException {
        try {
            String transactionHash = Hash.toHexString(calculateHash());

            if (!signingKeys.getPublicKeyString().equals(sender)) {
                throw new SignatureException("You cannot sign transactions from other wallets!");
            }
    
            signature = signingKeys.sign(transactionHash);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }
    

    public boolean isValid(SigningKeys signingKeys) throws SignatureException {
        if (sender.equals("System")) return true;

        if (signature.length() == 0) throw new SignatureException("There is no signature in this transaction!");

        return signingKeys.recieved();
    }
    */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }
    
    public int getAmount() {
        return amount;
    }

    public String getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }

    public String getTimeStamp() {
        return date.toString();
    }
}