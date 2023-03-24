import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        final String host = "127.0.0.1";
        final int port = 8989;

        try (Socket socket = new Socket(host, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Бизнес");
            System.out.println(in.readLine());
            while (in.ready()) {
                System.out.println(in.readLine());
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
