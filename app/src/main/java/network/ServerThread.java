package blockchain.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

public class ServerThread extends Thread {
    private ServerSocket serverSocket;
    private Set<ServerThreadThread> serverThreadThreads = new HashSet<ServerThreadThread>();

    public ServerThread(int portNum) throws IOException {
        serverSocket = new ServerSocket(portNum);
    }

    public void run() {
        try {
            while (true) {
                ServerThreadThread serverThreadThread = new ServerThreadThread(serverSocket.accept(), this);
                serverThreadThreads.add(serverThreadThread);
                serverThreadThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void sendMessage(String message) {
        try {
            serverThreadThreads.forEach(t-> t.getPrintWriter().println(message));
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public Set<ServerThreadThread> getServerThreadThreads() {
        return serverThreadThreads;
    }

}