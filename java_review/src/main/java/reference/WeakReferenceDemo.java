package reference;

import java.lang.ref.WeakReference;

/**
 * WeakReference
 * 弱引用,gc后为null
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {

        WeakReference<String> stringWeakReference = new WeakReference<>(new String("123"));
        System.out.println(stringWeakReference.get());
        System.gc();
        System.out.println(stringWeakReference.get());

    }
}
