package io.socket.socket_review;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author 伍六七
 * @date 2022/9/10 11:15
 */
public class GreetingServer extends Thread {
    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);  // 设置等待时间为10s
    }

    public void run() {
        while(true) {
            try {
                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");

                // 监听并接收套接字连接
                Socket server = serverSocket.accept();
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());

                // 输入流
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());

                // 输出流（将会在客户端输出）
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");

                server.close();
            }catch(SocketTimeoutException s) {  //如果时间耗尽
                System.out.println("Socket timed out!");
                break;  // 886退出程序
            }catch(IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
    public static void main(String [] args) {
        int port = 8080;  // 端口号
        try {
            Thread t = new GreetingServer(port);
            t.run();  // 开个线程
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}