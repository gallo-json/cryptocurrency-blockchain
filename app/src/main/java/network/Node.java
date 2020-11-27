package network;

import javax.json.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Node {
    private int port;
    private String name;
    private boolean receive;
    private ServerThread serverThread;

    public Node(int port, String name, boolean receive) {
        this.name = name;
        this.receive = receive;
        this.port = port;
        try {
            serverThread = new ServerThread(port);
            serverThread.start();
            updateListenToPeers();
        } catch (IOException e) {
            e.printStackTrace();
        }


        
    }

    public void updateListenToPeers() throws IOException {
        Scanner scanner = new Scanner(System.in);
        if (receive) {
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

        JsonObject value = Json.createObjectBuilder()
        .add("firstName", "John")
        .add("lastName", "Smith")
        .build();
        communicate(scanner, value);
    }

    public void communicate(Scanner scanner, JsonObject data) {
        try {
            System.out.println("Can now communicate (e to exit, c to change)");
            boolean flag = true;
            while (flag) {
                String message = scanner.nextLine();
                if (message.equals("e")) {
                    flag = false;
                    break;
                } else if (message.equals("c")) {
                    updateListenToPeers();
                } else {
                    sendMessage(data);
                }
            }
            System.exit(0);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public void sendMessage(JsonObject data) {
        StringWriter stringWriter = new StringWriter();
        Json.createWriter(stringWriter).writeObject(Json.createObjectBuilder()
        .add("miner", name)
        .add("block", Json.createObjectBuilder(data))
        .build());

        serverThread.sendMessage(stringWriter.toString());
    }
}