import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {

        String serverName = "localhost";
        int port = 6000;
        try {
            System.out.println("Connecting to server " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            System.out.println("Server says " + in.readUTF());
            client.close();
            System.out.println("Connection closed ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
