
package mychatserver;

/**
 *
 * @author maha
 */

import java.io.*;
import java.util.Vector;
import java.net.ServerSocket;
import java.net.Socket;

public class MyChatServer {
    
    ServerSocket serverSocket;
        
        public MyChatServer(){
            try
            {
                serverSocket = new ServerSocket(5005);
                while(true)
                {
                    Socket s = serverSocket.accept();
                    new ChatHandler(s);
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        
    public static void main(String[] args) {
        new MyChatServer();
    }
    
}

 class ChatHandler extends Thread{
    BufferedReader br;
    PrintStream ps;
    static Vector<ChatHandler> clientVector = new Vector<ChatHandler>();
    public ChatHandler(Socket cs){
        try
        {
            br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            ps  = new PrintStream(cs.getOutputStream());
            clientVector.add(this);
            start();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }  
    }
    
    
    public void run(){
        try
        {
            while(true)
            {
                String str = br.readLine();
                sendMessageToAll(str);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void sendMessageToAll(String msg)
    {
        for(ChatHandler ch : clientVector)
        {
            ch.ps.println(msg);
        }
    }
    
}