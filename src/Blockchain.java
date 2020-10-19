import java.utils.ArrayList;

public class Blockchain {
    ArrayList<Block[]> blockchain = new ArrayList<Block[]>();

    public Blockchain() {
        byte genesisHash = 0;
        // Genesis block
        blockchain.add(new Block(0, new Data(0, "genesis", "genesis", genesisHash)));
    }
}