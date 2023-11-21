package io.socket.UDPTalk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author 伍六七
 * @date 2022/8/14 22:51
 */
public class TalkSend {
    public static void main(String[] args) throws Exception {
        //获取连接
        DatagramSocket socket = new DatagramSocket(8080);
        while (true) {
            //准备数据
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            DatagramPacket packet = new DatagramPacket
                    (datas, 0,datas.length, new InetSocketAddress("localhost", 6666));
            //发送数据
            socket.send(packet);
            if (data.equals("bye")) {
                break;
            }
        }

        socket.close();


    }
}
