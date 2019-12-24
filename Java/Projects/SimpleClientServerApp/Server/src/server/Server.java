
package server;

/**
 *
 * @author maha
 */


import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Server {
    // creating SS
    ServerSocket myServerSocket;
    
    // creating internal-socket s, that will be assigned to client
    Socket s; 
    // High-level Input/Output streams for internal-socket s
    BufferedReader br;
    PrintStream ps;
    
    
    public static void main(String[] args) {
        new Server();
    }
    
    public Server()
    {
        try
        {
            myServerSocket = new ServerSocket(5005);
            s = myServerSocket.accept();
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            ps = new PrintStream(s.getOutputStream());
            String msg = br.readLine();
            System.out.println(msg);
            ps.println("Data Received");
        }
        
        catch(IOException ex)
                {
                    ex.printStackTrace();
                }
        try
        {
            ps.close();
            br.close();
            s.close();
            myServerSocket.close();
        }
        catch(Exception ex)
                {
                    ex.printStackTrace();
                }
    }
    
}
