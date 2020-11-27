package blockchain;

import blockchain.network.Peer;

public class FullNode extends Peer {
    public FullNode(int port, String name, boolean receiver) throws Exception {
        super(port, name, receiver);
    }
}