package Socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * socket通信，服务端
 * */

public class SocketCommunicationServer {

    static final int port = 8888;

    public static void main(String[] args)
    {
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            Socket s = serverSocket.accept();

            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            sendIP(dos);

            new SendThread(s).start();

            new ReceiveThread(s).start();
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


        int[] nums = new int[100];
        int[] numOfZero = new int[]{0};
        int[] multiple = new int[]{1};

        Arrays.stream(nums)
                .forEach(h -> {if(h == 0) numOfZero[0]++; else multiple[0] *= h;});
    }
}
