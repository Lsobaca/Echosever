import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Echoclient {
    public static void main(String[] args) {
       try {
           Socket client = new Socket("127.0.0.1",6007);
            PrintWriter pout = new PrintWriter(client.getOutputStream(),true);
            BufferedReader buff = new BufferedReader(new InputStreamReader(client.getInputStream()));

            Scanner in = new Scanner(System.in);
            while(true){
                System.out.println("Enter text: ");
                String echoline = in.nextLine();
                if ("end".equalsIgnoreCase(echoline)){
                    break;
                }
                pout.println(echoline);
                String reponse = buff.readLine();
                System.out.println("Server: "+ reponse);


            }
           client.close();



       } catch (IOException e)
           //TODO: handle exception
           System.out.println(e);
       } 
    }
    



}
