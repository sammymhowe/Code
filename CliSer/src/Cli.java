/**
 * Created by samantha on 12/30/16.
 */

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cli {

    public static void main(String []args) throws IOException {

        int val;
        int result;

        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 2222);

        // accept val from user
        System.out.println("Enter value: ");
        val = sc.nextInt();

        // send the val to be modded through the outputstream
        PrintStream p = new PrintStream(socket.getOutputStream());
        p.println(val);

        // get the result from the server through the inputstream
        Scanner sc1 = new Scanner(socket.getInputStream());
        result = sc1.nextInt();

        // print the result
        System.out.println(result);
    }

}
