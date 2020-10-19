import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {
    private int index;
    private Data data;
    private String timeStamp;
    private byte[] previousHash;
    private byte[] hash;

    public Block(int index, Data data, byte[] previousHash) {
        this.index = index;
        this.data = data;
        this.timeStamp = data.getTimeStamp();
        this.previousHash = previousHash;
        try {
            this.hash = calcuateHash();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }

    private byte[] calcuateHash() throws NoSuchAlgorithmException {
        return Hash.getSHA(index + Hash.toHexString(previousHash) + timeStamp);
    }

    @Override
    public String toString() {
        return String.format("Block %s:%n\t Ammount: %s%n\t Sender: %s%n\t Reciever: %s%n\t Timestamp: %s%n\t Previous hash: %s%n\t Hash: %s%n\t",
                            index, data.getAmount(), data.getSender(), data.getReciever(), timeStamp, Hash.toHexString(previousHash), Hash.toHexString(hash));
    }
}