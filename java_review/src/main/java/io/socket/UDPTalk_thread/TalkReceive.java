package io.socket.UDPTalk_thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author 伍六七
 * @date 2022/8/14 22:26
 */
public class TalkReceive implements Runnable{
    DatagramSocket socket = null;
    private int port;
    private String name;

    public TalkReceive(int port, String name) {
        this.port = port;
        this.name=name;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){

            //准备接受包裹
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
            try {
                socket.receive(packet);//阻塞式接受包裹
            } catch (IOException e) {
                e.printStackTrace();
            }
            //断开连接 bye
            byte[] data = packet.getData();
            String msg = new String(data, 0, data.length).trim();
            System.out.println(name + ": " + msg);
            if("bye".equals(msg)){
                break;
            }
        }
        socket.close();
    }
}
