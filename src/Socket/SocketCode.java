package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class SocketCode {

    public static void main(String[] args) throws Exception
    {
//        getHostIP();
        getIPInHostCanBeUsed();
    }


    public static void getHostIP() throws UnknownHostException
    {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        System.out.println("本机ip地址：" + ip);
    }

    public static void getIPInHostCanBeUsed() throws UnknownHostException, IOException
    {
        StringBuffer sb = new StringBuffer();

        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        System.out.println("本机的ip地址为：" + ip + "\r\n");

        ArrayList<String> ipCanUse = new ArrayList<>();

        String ip32_24 = ip.substring(0, 12); // 192.168.137.

        for(int i = 1; i <= 255; i++)
        {
            String ipNew = ip32_24 + i;
            if(canPingIP(ipNew))
                ipCanUse.add(ipNew);
            System.out.println("已完成" + i + "个ip的测试...\r\n");
        }

        sb.append("经过测试，可以用的IP地址共有" + ipCanUse.size() + "个，如下：\r\n");
        ipCanUse.stream()
                .forEach(h -> sb.append(h + "\r\n"));

        System.out.println(sb.toString());
    }

    public static boolean canPingIP(String ip) throws IOException
    {
        Process p = Runtime.getRuntime().exec("ping " + ip);
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        boolean flag = true;
        while((line = br.readLine()) != null)
        {
            if(line.length() != 0)
            {
                if(line.contains("请求超时"))
                {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    //ping成功的输出如下：
//    正在 Ping 192.168.137.1 具有 32 字节的数据:
//    来自 192.168.137.1 的回复: 字节=32 时间<1ms TTL=128
//    来自 192.168.137.1 的回复: 字节=32 时间<1ms TTL=128
//    来自 192.168.137.1 的回复: 字节=32 时间<1ms TTL=128
//    来自 192.168.137.1 的回复: 字节=32 时间<1ms TTL=128
//
//192.168.137.1 的 Ping 统计信息:
//    数据包: 已发送 = 4，已接收 = 4，丢失 = 0 (0% 丢失)，
//    往返行程的估计时间(以毫秒为单位):
//    最短 = 0ms，最长 = 0ms，平均 = 0ms

    //ping失败的输出如下：
//    正在 Ping 192.168.1.1 具有 32 字节的数据:
//    请求超时。
//    请求超时。
//    请求超时。
//    请求超时。
//
//            192.168.1.1 的 Ping 统计信息:
//    数据包: 已发送 = 4，已接收 = 0，丢失 = 4 (100% 丢失)，

}
