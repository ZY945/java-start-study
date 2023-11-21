package collection.map_s.hashmap_s;

import java.util.*;

/**
 * @author 伍六七
 * @date 2022/8/13 15:11
 * Hashmap
 */
public class hashmap_demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = map.getOrDefault(nums[i], 1);
            map.put(nums[i], num);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> list = new ArrayList<>();
                int temp = -(nums[i] + nums[j]);
                if (map.containsKey(temp) && map.get(temp) > 0) {
                    map.put(temp, map.get(temp) - 1);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(temp);
                    set.add(list);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }

    /**
     * getOrDefault(key, defaultValue)
     * 如果有该key，则返回对应的value，否则返回defaultValue
     */
    public static void getOrDefaultDemo() {
        new HashMap<>().getOrDefault(1, 2);
    }
}
