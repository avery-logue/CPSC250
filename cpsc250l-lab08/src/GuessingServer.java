import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class GuessingServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5150);
            System.out.println("Waiting for the client");

            Socket client = server.accept();
            System.out.println("Conneciton established");

            Scanner input = new Scanner(client.getInputStream());
            System.out.println("Recieved the client's input stream");

            PrintWriter output = new PrintWriter(client.getOutputStream(), true);
            System.out.println("Created client's output stream");
            //System.out.println("");
            int high = 0;
            int low = 0;
            int guess = 0;
            String response = "";

            low = input.nextInt();
            System.out.println("low is " + low);

            high = input.nextInt();
            System.out.println("high is " + high);

            input.nextLine();

            guess = (high + low)/2;
            System.out.println("guess is " + guess);
            output.println(guess);

            while(client.isConnected()){
                response = (input.next());
                System.out.println("response: " + response);

                if (response.equals("SHUT DOWN")) {
                    System.out.println("SHHUT DOWN");
                    client.close();
                    server.close();
                    break;
                }
                if(response.equals("high")){
                    high = guess;
                    System.out.println("Updated high: " + high);
                    guess = (high + low)/2;
                    System.out.println("Updated guess: " + guess);
                    output.println(guess);
                }

                if(response.equals("low")){
                    low = guess;
                    System.out.println("Updated low: " + low);
                    guess = (high + low)/2;
                    System.out.println("Updated guess: " + guess);
                    output.println(guess);
                } 

                if (response.equals("won")) {
                    System.out.println("GAME WON");
                }

                if (response.equals("lost")) {
                    System.out.println("GAME LOST");
                }

                System.out.println("REACHED BOTTOM");
            } 
            client.close();
            server.close();
        }
        catch (IOException e) {
            //client.close();
           // server.close();
        }
        System.out.println("SERVER HAS DIED");
    }
}
