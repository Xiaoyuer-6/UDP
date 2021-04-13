package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-04-13
 * Time: 20:53
 */
public class UDPServer {
    private static final int port = 8931;
    private static final int bleng = 1024;
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(port);
        System.out.println("服务器已启动！");
        while (true){
            //等待客户端的连接
            DatagramPacket clientPacket = new DatagramPacket(
                 new byte[bleng],
                 bleng
            );
            socket.receive(clientPacket);
            String msg = new String(clientPacket.getData());
            System.out.println("接收到客户端的信息："+msg);
            // 给客户端一个相应
            String serMsg = "我收到了";
            // 发送消息
            DatagramPacket serPacket = new DatagramPacket(
                    serMsg.getBytes(),
                    serMsg.getBytes().length, // 注意是字节长度
                    clientPacket.getAddress(),
                    clientPacket.getPort()
            );
            socket.send(serPacket);

        }
    }
}
