package blockchain;

import blockchain.network.Peer;

public class FullNode extends Peer {
    public FullNode(String name, boolean receiver) throws Exception {
        super(name, receiver);
    }
}