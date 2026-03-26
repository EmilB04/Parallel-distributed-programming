import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastSender {
    public static void main(String[] args) {
        String multicastAddress = "224.0.0.3";  // Multicast IP address
        int port = 6565;  // Port number
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress group = InetAddress.getByName(multicastAddress);
            String message = "Hello, This is a multicast message!";
            byte[] buffer = message.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            socket.send(packet);
            System.out.println("Message sent to multicast group: " + multicastAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
