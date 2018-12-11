import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class WebClient {
    public static void main(String[] args) throws  IOException{
        WebClient client = new WebClient();
        String s;
        Scanner scan = new Scanner(System.in);

        System.out.printf("URL : ");
        String s1 = scan.nextLine();
        s = client.getWebContentByGet(s1,"iso-8859-1",5000);
        System.out.println(s);

        System.out.printf("Andswer number : ");
        String ans = scan.nextLine();
        String s2 = "2015008904/" + ans;
        s1 = s1.replace("index.html","picResult");
        s = client.getWebContentByPost(s1, s2);
        System.out.println(s);

        System.out.print("URL : ");
        String s3 = scan.nextLine();
        s = client.getWebContentByPost(s3,"?");
        System.out.println(s);

        System.out.print("URL : ");
        String s4 = scan.nextLine();

        Image image = null;
        try {
            URL url = new URL(s4);
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);

    }

    public String getWebContentByGet(String urlString, final String charset, int timeout) throws IOException{
        if(urlString ==null || urlString.length() == 0){
            return null;
        }
        urlString = (urlString.startsWith("http://") || urlString.startsWith("https://")) ? urlString
                : ("http://" + urlString).intern();
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        conn.setRequestProperty("User-Agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");

//        conn.setRequestProperty("User-Agent",
//                "2015008904/SonGunHee/WEBCLIENT/COMPUTERNETWORK");

        conn.setRequestProperty("Accept", "text/html");
        conn.setConnectTimeout(timeout);
        try{
            if(conn.getResponseCode() != HttpURLConnection.HTTP_OK){
                return null;
            }
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
        InputStream input = conn.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, charset));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while((line = reader.readLine()) != null){
            sb.append(line).append("\r\n");
        }
        if(reader != null){
            reader.close();
        }
        if(conn != null){
            conn.disconnect();
        }
        return sb.toString();
    }
    public String getWebContentByPost(String urlString,String data) throws IOException {
        return getWebContentByPost(urlString, data,"iso-8859-1", 5000);
    }

    public String getWebContentByPost(String urlString, String data, final String charset, int timeout)
            throws  IOException {
        if (urlString == null || urlString.length() == 0) {
            return null;
        }
        urlString = (urlString.startsWith("http://") || urlString.startsWith("https://")) ? urlString
                : ("http://" + urlString).intern();
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");

        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);

        connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");

       //connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows vista)");
        connection.setRequestProperty("User-Agent", "2015008904/SonGunHee/WEBCLIENT/COMPUTERNETWORK");

        connection.setRequestProperty("Accept", "text/xml");
        connection.setConnectTimeout(timeout);
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());


        byte[] content = data.getBytes("UTF-8");

        out.write(content);
        out.flush();
        out.close();

        try {
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK){
                return null;
            }
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\r\n");
        }
        if (reader != null) {
            reader.close();
        }

        if (connection != null) {
            connection.disconnect();
        }

        return sb.toString();
    }
}