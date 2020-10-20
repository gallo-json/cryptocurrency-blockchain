import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Arrays;
import java.util.Date;

public class Block {
    private int index;
    private Data data;
    private String timeStamp;
    private byte[] previousHash;
    private byte[] hash;
    private int nonce = 0;

    public Block(int index, Data data, byte[] previousHash) {
        this.index = index;
        this.data = data;
        this.timeStamp = data.getTimeStamp();
        this.previousHash = previousHash;
        try {
            this.hash = calculateHash();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }

    public byte[] calculateHash() throws NoSuchAlgorithmException {
        return Hash.getSHA(index + Hash.toHexString(previousHash) + timeStamp + nonce + (data.getAmount() + data.getSender() + data.getReciever()));
    }

    public void mineBlock(int difficulty) {
        String zeros = String.join("", Collections.nCopies(difficulty, "0"));
        
        while(!((Hash.toHexString(hash).substring(0, difficulty)).equals(zeros))) {
            try {
                nonce++;
                hash = calculateHash();
            } catch (NoSuchAlgorithmException e) {
                System.out.println(e);
            }
        }

        System.out.println("Block mined: " + hash);
    } 

    public void setPreviousHash(byte[] previousHash) {
        this.previousHash = previousHash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }

    public byte[] getHash() {
        return hash;
    }

    public Data getData() {
        return data;
    } 

    @Override
    public String toString() {
        return String.format("Block %s:%n\t Amount: %s PepegaCoin%n\t Sender: %s%n\t Reciever: %s%n\t Timestamp: %s%n\t Previous hash: %s%n\t Hash: %s%n\t",
                            index, data.getAmount(), data.getSender(), data.getReciever(), timeStamp, Hash.toHexString(previousHash), Hash.toHexString(hash));
    }
}