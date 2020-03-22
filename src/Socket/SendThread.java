package Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{

    private Socket socket;

    public SendThread(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try{
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            Scanner sc = new Scanner(System.in);

            while(true)
            {
                dos.writeUTF(sc.nextLine());
            }

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
