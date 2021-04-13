package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-04-13
 * Time: 21:07
 */
public class UDPClient {
    private static final String ip = "1.116.95.77";
    private static final int port = 8931;
    private static final int bleng = 1024;

    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("->");
            String msg = scanner.nextLine();
            // 2.给服务器端发送消息
            DatagramPacket datagramPacket = new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName(ip),
                    port
            );
            client.send(datagramPacket);
            // 3.接收服务器的返回信息
            DatagramPacket serPacket = new DatagramPacket(
                    new byte[bleng],
                    bleng
            );
            client.receive(serPacket);
            // 接收到服务器端返回信息
            String serMsg = new String(serPacket.getData());
            System.out.println("服务器返回："+serMsg);
        }
    }
}

