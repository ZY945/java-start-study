package io.socket.UDPTalk;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 伍六七
 * @date 2022/8/14 22:51
 */
public class TalkReceive {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);
        while (true) {
            //准备接收包裹
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            socket.receive(packet);//阻塞式接收包裹


            byte[] data = packet.getData();
            String receiveData = new String(data, 0, data.length).trim();

            System.out.println(receiveData);

            //断开连接 bye
            if (receiveData.equals("bye")){
                break;
            }
        }
        socket.close();
    }
}
