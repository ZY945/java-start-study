package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 伍六七
 * @date 2023/9/6 23:04
 */
public class Main {

//    public static void main(String[] args) {
//        Instant start = Instant.now();
//        try (var executor = Executors.newFixedThreadPool(100)) {
//            for (int i = 0; i < 100000; i++) {
//                executor.submit(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            // 模拟业务时间
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                });
//            }
//        }
//        Instant finish = Instant.now();
//        long timeElapsed = Duration.between(start, finish).toMillis();
//        System.out.println("总耗时 : " + timeElapsed);
//    }
}