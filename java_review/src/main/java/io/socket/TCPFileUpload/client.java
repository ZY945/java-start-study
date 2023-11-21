package io.socket.TCPFileUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 伍六七
 * @date 2022/8/14 21:42
 */
public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        String filePath = "";
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File(filePath));
        byte[] bytes = new byte[1024];
        int len;
        while((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        fis.close();
        os.close();
        socket.close();
    }
}
