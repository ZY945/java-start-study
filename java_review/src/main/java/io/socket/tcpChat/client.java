package io.socket.tcpChat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 伍六七
 * @date 2022/8/14 21:12
 * 客户端
 */
public class client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            Socket socket = new Socket("localhost", 8080);

            OutputStream os = socket.getOutputStream();

            String msg = scanner.next();
            os.write(msg.getBytes());
            if("bye".equals(msg)){
                os.close();

                break;
            }

            os.close();
        }
    }
}
