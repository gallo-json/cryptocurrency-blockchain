package network;

import java.io.*;
import java.net.Socket;

import javax.json.*;

public class PeerThread extends Thread {
    private BufferedReader bufferedReader;

    public PeerThread(Socket socket) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() {
        boolean flag = true;

        while (flag) {
            try {
                JsonObject jsonObject = Json.createReader(bufferedReader).readObject();
                if (jsonObject.containsKey("username"))
                    System.out.println("[" + jsonObject.getString("username") + "]: " + jsonObject.getString("message"));

            } catch (Exception e) {
                flag = false;
                interrupt();
            }
        }
    }
}