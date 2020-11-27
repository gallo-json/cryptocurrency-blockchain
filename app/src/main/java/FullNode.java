package blockchain;

public class FullNode extends Peer {
    public FullNode() {
        super(3001, "fullnode", true);
    }
}