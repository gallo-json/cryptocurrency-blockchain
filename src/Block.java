import java.security.NoSuchAlgorithmException;
import java.time.Date;

public class Block {
    private int index;
    private Data data;
    private int timeStamp;
    private byte[] previousHash;
    private byte[] hash;

    public Block(int index, Data data, byte[] previousHash) {
        this.index = index;
        this.data = data;
        this.timeStamp = data.getTimeStamp();
        this.previousHash = previousHash;
        this.hash = calcuateHash();
    }

    private calcuateHash() {
        return Hash.getSHA(index + previousHash + timeStamp);
    }
}