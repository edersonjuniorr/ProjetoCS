import java.net.*;
import java.io.*;

public class server {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(5999);
        Socket s = ss.accept();

        System.out.println("Conexão bem sucedida com o cliente.");

        InputStreamReader isr = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();
        System.out.println("Mensagem oriunda do cliente:" + str);

    }
}