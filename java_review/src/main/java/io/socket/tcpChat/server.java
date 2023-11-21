package io.socket.tcpChat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 伍六七
 * @date 2022/8/14 21:12
 * TCP连接得先开启服务器
 * 服务端
 */
public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        Socket socket = null;

        InputStream is = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        while(true){
            socket=ss.accept();

            System.out.println(socket.getRemoteSocketAddress());

            is = socket.getInputStream();

            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer))!=-1){
                byteArrayOutputStream.write(buffer,0,len);

            }
            System.out.println(byteArrayOutputStream.toString());
            if("bye".equals(byteArrayOutputStream.toString())){
                break;
            }
        }
        byteArrayOutputStream.close();
        is.close();
        socket.close();
        ss.close();
    }
}
