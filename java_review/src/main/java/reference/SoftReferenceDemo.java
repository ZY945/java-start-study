package reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * -XX:+PrintGCDetails -Xmx10m -Xms10M
 * Java heap space抛出前,该引用会被清空为null,但是softReference还是存在的，只是无法.get到了
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
        SoftReference<byte[]> softReference = new SoftReference<>(new
                byte[1024 * 1024]);
        System.out.println("before gc:" + softReference);
        ArrayList<byte[]> byteList = new ArrayList<>();
        int i = 0;
        while (true) {
            byteList.add(new byte[1024 * 1024]);
            System.out.println(++i + "memory" + softReference);
        }
    }
}
