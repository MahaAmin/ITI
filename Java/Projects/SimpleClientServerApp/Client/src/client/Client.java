
package client;

/**
 *
 * @author maha
 */

import java.net.Socket;
import java.io.*;

public class Client {
    
    Socket mySocket;
    BufferedReader br;
    PrintStream ps;
    
    public static void main(String[] args) {
        new Client();
    }
    
    
    public Client()
    {
        try
        {
            mySocket = new Socket("127.0.0.1", 5005);
            br = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            ps = new PrintStream(mySocket.getOutputStream());
            ps.println("Test Test");
            String replyMsg = br.readLine();
            System.out.println(replyMsg);
        }
        catch(IOException ex)
                {
                    ex.printStackTrace();
                }
        
        try
        {
            ps.close();
            br.close();
            mySocket.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
}
