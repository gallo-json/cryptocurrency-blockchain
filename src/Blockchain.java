import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Blockchain {
    ArrayList<Block> blockchain = new ArrayList<Block>();
    private int difficulty = 5;

    public Blockchain() {
        byte[] genesisHash = new byte[0];
        // Genesis block
        blockchain.add(new Block(0, new Data(0, "Genesis", "Genesis", new Date()), genesisHash));
    }

    public Block getBlock(int i) {
        return blockchain.get(i);
    }
    
    private Block getLatestBlock() {
        return blockchain.get(blockchain.size() - 1);
    }

    public void addBlock(Data data) {
        Block newBlock = new Block(blockchain.size(), data, getLatestBlock().getHash());
        newBlock.mineBlock(difficulty);
        blockchain.add(newBlock);
    }

    public boolean isChainValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);
            
            try {
                if (!Arrays.equals(currentBlock.getHash(), currentBlock.calculateHash()) || !Arrays.equals(previousBlock.getHash(), previousBlock.calculateHash())) return false;
            } catch (NoSuchAlgorithmException e) {
                //TODO: handle exception
                System.out.println(e);
                return false;
            }
        }
        return true;
    }

    public void printAsString() {
        for (Block block : blockchain) {
            System.out.println(block.toString());
        }
    }
}