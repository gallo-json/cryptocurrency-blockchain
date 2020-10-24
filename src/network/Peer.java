package network;

import java.io.*;

public class Peer {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter username and port for this peer: ");
        String[] setupValues = bufferedReader.readLine().split(" ");
    }
}