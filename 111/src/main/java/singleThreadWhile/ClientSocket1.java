package singleThreadWhile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author lengyue
 * @created 2021-03-09
 **/
public class ClientSocket1 {
    public static void main(String[] args) {
        try {
            //初始化一个socket
            Socket socket = new Socket("127.0.0.1", 1589);
            //通过socket获取字符流
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //通过标准输入流获取字符流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            while (true) {
                String str = bufferedReader.readLine();
                bufferedWriter.write(str);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

}
}
