import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Echoclient {
    public static void main(String[] args) {
       try {
            //connects with the echo server on port 6007 using the localhost ip.
            Socket client = new Socket("127.0.0.1",6007);

            PrintWriter pout = new PrintWriter(client.getOutputStream(),true);
            BufferedReader buff = new BufferedReader(new InputStreamReader(client.getInputStream()));

            Scanner in = new Scanner(System.in);
            /*
            the client is going to prompt the user for some text to yell in a canyon
            the user would see that the server had responded to the text that the 
            user has put in.
            to end the program, the user has to put "end". end can be in any case since
            we used equalsIngnoreCase.
            */
            while(true){
                System.out.println("Enter text: ");
                System.out.print("Client: ");
                String echoline = in.nextLine();
                if ("end".equalsIgnoreCase(echoline)){
                    break;
                }
                pout.println(echoline);
                String reponse = buff.readLine();
                System.out.println("Server: "+ reponse);
            }

           client.close();

       } catch (IOException e) {
           //TODO: handle exception
           System.out.println(e);
       } 
    }
    



}
