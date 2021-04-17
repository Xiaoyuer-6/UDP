package udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-04-17
 * Time: 11:30
 */
//UDP服务器端
public class UDPServer {
    private static final int port = 9001;//端口号
    private static final int bleng =1024 ;//传递数据的最大值
    public static void main(String[] args) throws IOException {
        //1、启动一个UDP服务器端(ip默认电脑的ip,端口号要设置)
        DatagramSocket socket = new DatagramSocket(port);
        System.out.println("服务器已启动！");
        //ip为默认ip
        while (true){
            //检测是否有人来连接服务器端,
            //2、初始化数据包
            DatagramPacket clientPacket = new DatagramPacket(
                    new byte[bleng],bleng//byte数组存放传送的数据的集合，bleng为传送数据的长度
            );
            //3、等待客户端的连接（正式执行）receive方法需要DatagramPacket，客户端有这个的包才能链接
            socket.receive(clientPacket);//服务器端接收到客户端的包
            //此时已连接到客户端（IP，地址，端口）
            //4、接受客户端的信息
            String msg = new String(clientPacket.getData());
            System.out.println("接收到客户端的信息:"+msg);
            //5、给客户端一个响应
            String serMsg =msg.replace("吗",".");
            //发送消息
            DatagramPacket serPacket = new DatagramPacket(
                serMsg.getBytes(),
                    serMsg.getBytes().length,//字节长度
                    clientPacket.getAddress(),
                    clientPacket.getPort()
            );
            socket.send(serPacket);
        }
    }
}
