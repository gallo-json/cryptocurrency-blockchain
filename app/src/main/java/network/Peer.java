package blockchain.network;

import javax.json.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Peer {
    private int port;
    private String name;
    private boolean receiver;
    private ServerThread serverThread;

    public Peer(int port, String name, boolean receiver) throws IOException {
        this.port = port;
        this.name = name;
        this.receiver = receiver;

        while (true) {
            try {
                serverThread = new ServerThread(port);
                serverThread.start();
                break;
            } catch (BindException e) {
                port++;
            }
        }

        try {
            updateListenToPeers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Your port: " + port);
    }

    private void updateListenToPeers() throws Exception {
        Scanner scanner = new Scanner(System.in);
        if (receiver) {
            System.out.println("Enter hostname:port for peers to receive data from (separated by a space):");
            String[] inputValues = scanner.nextLine().split(" ");

            for (int i = 0; i < inputValues.length; i++) {
                String[] address = inputValues[i].split(":");
                Socket socket = null;

                try {
                    socket = new Socket(address[0], Integer.valueOf(address[1]));
                    new PeerThread(socket).start();
                } catch (Exception e) {
                    if (socket != null) socket.close();
                    else System.out.println("Invalid input.");
                }
            }
        }

        System.out.println("Can now communicate with other peers");
    }

    protected void send(JsonObject data) {
        StringWriter stringWriter = new StringWriter();
        Json.createWriter(stringWriter).writeObject(Json.createObjectBuilder()
            .add("miner", name)
            .add("block", Json.createObjectBuilder(data))
        .build());

        serverThread.sendMessage(stringWriter.toString());
    }
}