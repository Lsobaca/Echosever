import java.net.*;
import java.io.*;

public class Echoserver{
    public static void main(String args[]) {
        try {
            ServerSocket Echo = new ServerSocket(6007);
            Socket client = Echo.accept();
            System.out.println("Connected to client");

            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter pout = new PrintWriter(client.getOutputStream(),true);

            String echo;

            while((echo = buf.readLine())!= null){
                System.out.println("Server: " + echo);
                pout.println(echo);


                
            }
            client.close();


        } catch (IOException e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }
}