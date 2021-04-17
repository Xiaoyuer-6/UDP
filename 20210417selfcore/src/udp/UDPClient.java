package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-04-17
 * Time: 14:46
 */
//客户端
public class UDPClient {
    //不设置端口号
    //服务器的IP地址
    private static final String ip = "1.116.95.77";
    //服务器的端口号ni
    private static final int port = 9001;
    private static final int bleng =1024;
    public static void main(String[] args) throws IOException {
        //1、启动客户端
        DatagramSocket client = new DatagramSocket();

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("我: ");
            String msg = scanner.nextLine();
            //2、发送消息给服务器端
            DatagramPacket datagramPacket = new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName(ip),
                    port
            );
            client.send(datagramPacket);
            //3、接收服务器的返回信息
            DatagramPacket serPacket = new DatagramPacket(
                new byte[bleng],
                    bleng
            );
            client.receive(serPacket);
            //4、接受服务器端的响应信息
            String serMsg = new String(serPacket.getData());
            System.out.println("对方:"+serMsg);
        }
    }
}
