import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    public static void main(String[] args) {
        String multicastAddress = "224.0.0.3";
        System.out.println("\nWaiting for client on address: " + multicastAddress);
        int port = 6565;
        try (MulticastSocket socket = new MulticastSocket(port)) {
            InetAddress group = InetAddress.getByName(multicastAddress);
            socket.joinGroup(group);  // Join (subscribe) the multicast group
            // System.out.println("Receiver listening for multicast messages...");

            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);  // Wait for incoming message
            String receivedMessage = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received from client: " + receivedMessage);
            System.out.println("Message sent from IP address: " + packet.getAddress() + " and port: " + packet.getPort());

            socket.leaveGroup(group);  // Leave group after receiving
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
