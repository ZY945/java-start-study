package io.socket.UDPTalk_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author 伍六七
 * @date 2022/8/14 22:26
 */
public class TalkSend implements Runnable{
    DatagramSocket socket = null;
    BufferedReader reader = null;
    private int fromPort;
    private String toIP;
    private int toPort;

    public TalkSend(int fromPort, String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;

        try {
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            String msg = null;
            try {
                msg = reader.readLine();
                DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, new InetSocketAddress(this.toIP,this.toPort));
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if("bye".equals(msg)){
                break;
            }
        }
        socket.close();
    }
}
