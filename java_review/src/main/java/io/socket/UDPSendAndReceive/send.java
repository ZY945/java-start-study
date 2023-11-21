package io.socket.UDPSendAndReceive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 伍六七
 * @date 2022/8/14 21:57
 */
public class send {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8080);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String msg = bufferedReader.readLine();

            DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, InetAddress.getByName("localhost"),6666);

            socket.send(packet);
            if("bye".equals(msg)){
                break;
            }
        }

        socket.close();
    }
}
