import java.util.Date;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.KeyPair;

public class Transaction {
    private int amount;
    private String sender;
    private String reciever;
    private Date date = new Date();
    private String[] signature;
    private SigningKeys signingKeys;

    public Transaction(int amount, String sender, String reciever) {
        this.amount = amount; 
        this.sender = sender;
        this.reciever = reciever;
    }

    public byte[] calculateHash() throws NoSuchAlgorithmException {
        return Hash.getSHA(sender + reciever + amount);
    }

    public void signTransaction(SigningKeys signingKeys, KeyPair keyPair) throws SignatureException {
        this.signingKeys = signingKeys;

        try {
            String transactionHash = Hash.toHexString(calculateHash());

            if (!signingKeys.toString(keyPair.getPublic()).equals(sender)) {
                throw new SignatureException("You cannot sign transactions from other wallets!");
            }
    
            signature = signingKeys.sign(transactionHash, keyPair);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean isValid() throws SignatureException {
        try {
            if (sender.equals("System")) return true;

            if (signature.length == 0) throw new SignatureException("No signature in this transaction");

            return signingKeys.received(signature);
        } catch (Exception e) {
            return false;
        }
    }

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