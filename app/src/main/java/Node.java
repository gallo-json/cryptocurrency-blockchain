package blockchain;

import network.Peer;
import java.io.IOException;

public class Node {
    public static void main(String[] args) throws IOException{
        Peer peer = new Peer();
        peer.start();
    }
}