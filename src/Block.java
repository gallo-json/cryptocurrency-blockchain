import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {
    private int index;
    private Data data;
    private String timeStamp;
    private byte[] previousHash;
    private byte[] hash;

    public Block(int index, Data data) {
        this.index = index;
        this.data = data;
        this.timeStamp = data.getTimeStamp();
        try {
            this.hash = calculateHash();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }

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
        return Hash.getSHA(index + Hash.toHexString(previousHash) + timeStamp);
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

    @Override
    public String toString() {
        return String.format("Block %s:%n\t Amount: %s PepegaCoin%n\t Sender: %s%n\t Reciever: %s%n\t Timestamp: %s%n\t Previous hash: %s%n\t Hash: %s%n\t",
                            index, data.getAmount(), data.getSender(), data.getReciever(), timeStamp, Hash.toHexString(previousHash), Hash.toHexString(hash));
    }
}