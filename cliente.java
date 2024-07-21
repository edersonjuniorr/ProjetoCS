import java.net.*;
import java.io.*;

public class cliente {
    public static void main(String[] args) throws IOException{
        Socket sc = new Socket("localhost", 5999);

        PrintWriter pr = new PrintWriter(sc.getOutputStream());
        pr.println("Olá");
        pr.flush();
    }
}