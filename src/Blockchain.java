import java.util.ArrayList;
import java.util.Date;

public class Blockchain {
    ArrayList<Block> blockchain = new ArrayList<Block>();

    public Blockchain() {
        byte[] genesisHash = new byte[0];
        // Genesis block
        blockchain.add(new Block(0, new Data(0, "genesis", "genesis", new Date()), genesisHash));
    }
    
    private Block getLatestBlock() {
        return blockchain.get(blockchain.size() - 1);
    }
    public void printAsString() {
        for (Block block : blockchain) {
            System.out.println(block.toString());
        }
    }
}