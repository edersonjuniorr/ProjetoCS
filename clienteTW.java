import java.net.*;
import java.io.*;
import java.util.Scanner;

public class clienteTW{
    public static void main(String[] args) throws IOException{
        Socket sc = new Socket("localhost", 5999);

        
        PrintWriter pr = new PrintWriter(sc.getOutputStream());
        Scanner r = new Scanner(System.in);
        System.out.println("Mensagem: ");
        String msg = r.nextLine();
        pr.println(msg);
        pr.flush();

        InputStreamReader isr = new InputStreamReader(sc.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();
        System.out.println("Mensagem resposta do servidor: "+ str);
    }
}