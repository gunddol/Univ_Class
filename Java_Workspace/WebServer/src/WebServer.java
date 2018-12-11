import java.io.*;
import java.net.*;

public class WebServer {
    public static void main(String[] args){
        int port = 9999;
        try{
            ServerSocket serverSocket = new ServerSocket(port);

            while(true){
                Socket connectionSock = serverSocket.accept();

                HttpRequest request = new HttpRequest(connectionSock);


                //Thread thread = new Thread(request);
                Thread thread =new Thread(request);
                thread.start();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
