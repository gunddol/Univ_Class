import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.util.Scanner;

public class UDPServer extends Thread{
    public void run(){
        DatagramPacket receivePacket, sendPacket = null;
        final int PORTNUMBER = 3000;
        MulticastSocket ms = null;

        super.run();
        try{
            ms = new MulticastSocket(PORTNUMBER);
            System.out.println(PORTNUMBER + " Port Server Ready");

            while(true){
                byte[] buf = new byte[62000];
                receivePacket = new DatagramPacket(buf, buf.length);

                ms.receive(receivePacket); //Q1

                String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("From Opponent Client MSG: " + msg);


                if (msg.contains("next step") || msg.contains("What is") || msg.contains("How")) {
                    Scanner sc = new Scanner(System.in);
                    String sendMessage = sc.nextLine();
                    sendPacket = new DatagramPacket(sendMessage.getBytes(), sendMessage.length(),receivePacket.getAddress(),receivePacket.getPort()); //Q2
                    ms.send(sendPacket);
                }else if(msg.contains("Client")){
                    System.out.println("port 번호를 입력");
                    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                    int port = Integer.parseInt(bf.readLine());

                    UDPClient uc = new UDPClient(port);
                    uc.start();
                }

            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            ms.close();
        }
    }
}
