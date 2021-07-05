package multhread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author lengyue
 * @created 2021-02-28
 **/
public class Client {
    public static final String host="localhost";
    public static final int port=8999;

    public static void main(String[] args) throws IOException {
        Socket socket=new Socket(host,port);
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        try {
            bufferedReader =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            bufferedWriter.write("hello服务器!!!!");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String line = bufferedReader.readLine();
            System.out.println(Thread.currentThread().getName()+" 从客户端收到内容: "+line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}

