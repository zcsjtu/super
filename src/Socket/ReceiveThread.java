package Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiveThread extends Thread {

    private Socket socket;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ReceiveThread(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try{
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            while(true)
            {
                String msg = dis.readUTF();
                System.out.println(simpleDateFormat.format(new Date()) + "\r\n" + msg);
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
