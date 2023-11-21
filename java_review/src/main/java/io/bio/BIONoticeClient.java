package io.bio;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BIONoticeClient {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("输入用户名:");
//        String userName = scanner.next();
//
//        //开启连接socket
//        System.out.println("等待连接成功");
//        String host="127.0.0.1";
//        int port = 8080;
//        Socket socket = new Socket(host, port);
//        socket.getOutputStream().write(userName.getBytes());
//        socket.getOutputStream().flush();
//        byte[] bytes = new byte[1024];
//        int read = socket.getInputStream().read(bytes);
//        String notice = new String(bytes, 0, read);
//        System.out.println("服务器通知:"+notice);
//        while(scanner.hasNext()){
//            String next = scanner.next();
//            if(next.equals("Exit")){
//                break;
//            }
//            socket.getOutputStream().write(next.getBytes());
//            socket.getOutputStream().flush();
//        }
//        String exit = userName+"已退出";
//        socket.getOutputStream().write(exit.getBytes());
//        socket.getOutputStream().flush();
        long now = System.currentTimeMillis();//linux是UTC,本机是Asia/Shanghai
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleFormatter.format(new Date(now));
        System.out.println(format);
    }
}
