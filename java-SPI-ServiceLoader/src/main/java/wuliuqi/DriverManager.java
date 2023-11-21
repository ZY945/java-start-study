package wuliuqi;

import wuliuqi.SPI.Driver;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author 伍六七
 * @date ${DATE} ${TIME}
 */
public class DriverManager {
    public static void main(String[] args) {

    }
    static {
        loadInitialDrivers();
    }

    private static void loadInitialDrivers() {
        AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
            ServiceLoader<Driver> load = ServiceLoader.load(Driver.class);
            Iterator<Driver> driverIterator = load.iterator();
            try {
                while (driverIterator.hasNext()){
                    driverIterator.next();
                }
            }catch (Throwable throwable){
                System.out.println(throwable);
            }
            return null;
        });
    }
}