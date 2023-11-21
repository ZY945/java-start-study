package annotation.redis;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RedisUtil {
    private static final ConcurrentHashMap<String, Node> redis = new ConcurrentHashMap<>();

    public static void run() {
        for (; ; ) {
            redis.values().forEach(l -> {
                long now = System.currentTimeMillis();
                if (now > l.expired) {
                    redis.remove(l.key);
                }
            });
        }
    }

    static class Node {
        private final String key;
        private final AtomicInteger integer;
        private final long expired;

        public Node(String key, long expired) {
            this.key = key;
            this.integer = new AtomicInteger();
            this.expired = expired;
        }
    }

    public static void expired(String key, final long timeout, final TimeUnit unit) {
        synchronized (RedisUtil.class) {
            long expired = System.currentTimeMillis() + unit.toMillis(timeout);
            Node node = new Node(key, expired);
            redis.put(key, node);
        }
    }


    public static void increment(String key) {
        synchronized (RedisUtil.class) {
            Node node = redis.get(key);
            if (node == null) {
                throw new RuntimeException("没有该key");
            } else {
                node.integer.incrementAndGet();
            }
        }
    }

    public static Integer get(String key) {
        if (redis.get(key) != null) {
            return redis.get(key).integer.get();
        }
        return null;
    }
}
