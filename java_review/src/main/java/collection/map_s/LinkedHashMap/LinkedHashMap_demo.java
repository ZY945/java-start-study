package collection.map_s.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dongfeng
 * @description TODO
 * @date 2023-10-30 20:33
 */
public class LinkedHashMap_demo {
    public static void main(String[] args) {
        Map<String, Object> map = new LRUCache<>(2);
        map.put("2", 1);
        map.put("4", 5);
        map.put("1", 2);
        System.out.println(map);
        map.get("4");
        System.out.println(map);
    }

    /**
     * LRU,最近最少使用,优先淘汰最近最不常用的数据
     */
    static class LRUCache<S,C> extends LinkedHashMap<S,C> {
        public LRUCache(int maxSize) {
            super(maxSize, 0.75F, true);
            maxElements = maxSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<S, C> eldest) {
            if(size()== 1 + maxElements){
                return true;
            }
            return super.removeEldestEntry(eldest);
        }

        private static final long serializeUID = 1L;
        protected int maxElements;
    }
}
