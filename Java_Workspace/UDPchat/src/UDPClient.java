import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient extends Thread{
    int port=3000;
    public UDPClient(int port){
        this.port = port;
    }
    public void run(){
        DatagramSocket datagramSocket = null;
        DatagramPacket receivePacket, sendPacket = null;
        InetAddress inetAddress = null;
        InetAddress server = null;
        BufferedReader br = null;
        int portNumber = 3000;

        try{
//            inetAddress = InetAddress.getByName("192.168.1.10");
            inetAddress = InetAddress.getByName("166.104.143.225");
            datagramSocket = new DatagramSocket();

            br = new BufferedReader(new InputStreamReader(System.in));

            while(true){
                System.out.println(portNumber + " Connect to Opponent server port");
                String msg = "";
                System.out.print("Input Message : ");
                msg = br.readLine();

                sendPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, inetAddress, port);
                datagramSocket.send(sendPacket);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            datagramSocket.close();
        }

        try{
            while(true){
                byte[] buf = new byte[62000];
                server = InetAddress.getByName("166.104.143.225");
                receivePacket = new DatagramPacket(buf, buf.length, server, port);
                datagramSocket.receive(receivePacket);

                String msg = new String(receivePacket.getData(), 0, receivePacket.getData().length);
                System.out.println("From Server" + msg);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
