package io.socket.UDPSendAndReceive;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 伍六七
 * @date 2022/8/14 21:57
 * UDP通讯
 */
public class receive {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);
        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
            socket.receive(packet);
            byte[] data = packet.getData();
            String msg = new String(data, 0, data.length).trim();
            System.out.println(msg);
            if("bye".equals(msg)){
                break;
            }
        }

        socket.close();
    }
}
