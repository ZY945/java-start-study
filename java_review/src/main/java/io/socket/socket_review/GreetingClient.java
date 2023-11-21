package io.socket.socket_review;

import java.io.*;
import java.net.Socket;

/**
 * @author 伍六七
 * @date 2022/9/10 11:15
 */
public class GreetingClient {
    public static void main(String [] args) {
        String serverName = "localhost";
        int port = 8080;  // 端口号
        try
        {
            System.out.println("连接到主机：" + serverName + " ，端口号：" + port);

            // 创建一个套接字并将其连接到指定主机上的指定端口号
            Socket client = new Socket(serverName, port);

            // 获取套接字端口地址
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());

            // 输出流（将会在服务器端输出）
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("Hello from " + client.getLocalSocketAddress());

            //输入流
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());

            client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
