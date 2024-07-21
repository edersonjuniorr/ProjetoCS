import java.net.*;
import java.io.*;
import java.net.InetAddress;

public class serverI{
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(5252);
        Socket s = ss.accept();
        var id = s.getInetAddress().getHostAddress();
        
        byte[] ipBytes = s.getInetAddress().getAddress();
        boolean ipInRange = ipBytes.length == 4 && ipBytes[0] == 127 && ipBytes[1] == 0 && ipBytes[2] == 0 && ipBytes[3] >= 1 && ipBytes[3] <= 255;

        if(ipInRange){
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            System.out.println("Conexão bem sucedida com o cliente.");
            System.out.println(id + "/" + s.getInetAddress().getHostName());
            System.out.println("\n");
            BufferedReader br = new BufferedReader(isr);
            String str = br.readLine();
            System.out.println("Mensagem oriunda do cliente: "+ str);

            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.println("Certificado o recebimento da mensagem.");
            pr.flush();
        }
        else{
            System.out.println("Uma conexão foi impossibilitada: IP fora do range estabelecido tentando se conectar.");
            System.out.println(id);
            ss.close();
        }                        

    }
}