package io.socket.TCPFileUpload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 伍六七
 * @date 2022/8/14 21:42
 */
public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("fileupload.png"));

        byte[] buffer = new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
