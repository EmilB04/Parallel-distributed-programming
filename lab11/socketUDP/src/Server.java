import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) {
        try {
            int server_port = 9802;
            DatagramSocket serverSocket = new DatagramSocket(server_port);
            System.out.println("Waiting for client on port " + server_port);
            byte[] receiveData = new byte[11];
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                InetAddress IPAddress = receivePacket.getAddress();
                int client_port = receivePacket.getPort();

                System.out.println("Received from client: " + sentence);
                System.out.println("Message sent from IP address: " + IPAddress + " and port: " + client_port);

                sentence = "Welcome from server" ;
                byte[] sendData = sentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, client_port);
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}