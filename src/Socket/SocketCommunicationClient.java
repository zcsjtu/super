package Socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * socket通信 客户端
 * */

public class SocketCommunicationClient {

    static final String ip = "super941209.nat123.net";
    static final int port = 37085;

//    static final String ip = "127.0.0.1";
//    static final int port = 8888;

    public static void main(String[] args)
    {
        try{
            Socket socket = new Socket(ip, port);

            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            sendIP(dos);

            new SendThread(socket).start();

            new ReceiveThread(socket).start();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void sendIP(DataOutputStream dos)
    {
        try{
            InetAddress localHost = InetAddress.getLocalHost();
            String ip = localHost.getHostAddress();

            dos.writeUTF("已连接，我方ip为：" + ip);

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
