import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");
            int port = 9802;


            String sentence = "Hello world";
            byte[] sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            clientSocket.send(sendPacket);

            byte[] receiveData = new byte[19];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String receivedSentence = new String(receivePacket.getData());
            System.out.println("Received from server: " + receivedSentence);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
