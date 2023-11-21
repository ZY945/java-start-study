package io.socket.UDPTalk_thread;

import java.net.SocketException;

/**
 * @author 伍六七
 * @date 2022/8/14 22:26
 */
public class TalkMain1 {
    public static void main(String[] args) throws SocketException {
        new Thread(new TalkSend(8888,"localhost",6666),"meng").start();
        new Thread(new TalkReceive(8080,"梅花十三")).start();
    }
}
