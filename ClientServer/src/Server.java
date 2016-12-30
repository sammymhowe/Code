/**
 * Created by samantha on 12/30/16.
 */

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {

    public static void main(String []args) throws IOException {

        int valMod;

        // accepts incoming request from client
        ServerSocket listener = new ServerSocket(2222);
        Socket socket = listener.accept();

        while(true) {
            // get the input to the server through inputstream
            Scanner sc = new Scanner(socket.getInputStream());
            valMod = sc.nextInt();

            // modify that input
            valMod += 2;

            // send the result to the outputstream
            PrintStream p = new PrintStream(socket.getOutputStream());
            p.println(valMod);
        }
    }

}
