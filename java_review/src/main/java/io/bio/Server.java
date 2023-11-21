package io.bio;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class Server {
    private static int userMaxNumber = 8;
    // 核心数就是最大支持的连接,多余的连接会等已连接的退出后进行连接
    private static ExecutorService executorService = new ThreadPoolExecutor(userMaxNumber,16,30, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));
    private static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        int port = 8080;
        // 1.注册端口
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            System.out.println("等待服务端连接");
            countThread();
            // 2.accept阻塞等待连接
            Socket client = serverSocket.accept();
            // 3.操作Socket的IO流进行读写
            handle(client);
        }
    }

    private static void handle(Socket client) {
        executorService.execute(() -> {
            byte[] bytes = new byte[1024];
            try {
                int read = client.getInputStream().read(bytes);
                String data = new String(bytes, 0, read);
                System.out.println(data + "登陆成功");
                // TODO 未判断
                set.add(data);
                String notice = "欢迎" + data + "登录此系统";

                client.getOutputStream().write(notice.getBytes());
                client.getOutputStream().flush();
                while (true) {
                    String dataStr = new String(bytes, 0, client.getInputStream().read(bytes));
                    if (dataStr.equals("Exit")) {
                        set.remove(data);
                        Thread.currentThread().interrupt();
                        Thread.sleep(1000L);
                        break;
                    }
                    System.out.println(data + ":" + dataStr);
                }

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public static void countThread(){
        Thread mainThread = Thread.currentThread();
        ThreadGroup mainThreadThreadGroup = mainThread.getThreadGroup();
        //获取线程组中的线程。
        int count = mainThreadThreadGroup.activeCount();
        System.out.println("总线程数:"+count);
        System.out.println("已连接的线程数:"+(count-2));
        Thread[] threads = new Thread[count];
        //enumerate 枚举，recurse 递归
        mainThreadThreadGroup.enumerate(threads, true);
        Stream.of(threads).filter(Thread::isAlive).forEach(thread -> System.out.println("线程池的线程：" + thread ));
    }
}
