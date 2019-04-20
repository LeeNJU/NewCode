package HashTable;

import java.util.TreeMap;

//题目描述:实现一个class的insert和sum方法，insert可以插入key-value pair，sum方法给出一个前缀字符串，找到所有满足前缀的key的字符串，把value求和，例如insert("apple", 3)
//       sum("ap"),返回3，insert("app", 2)，sum("ap")返回5，因为"apple"和"app"都满足"ap"的前缀
//解法描述:可以利用trie，也可以用treemap的HigherKey和CeilingKey方法逐一搜索

public class MapSumPairs {

    private TreeMap<String, Integer> map;

    public MapSumPairs() {
        map = new TreeMap<String, Integer>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int result = 0;
        String key = map.ceilingKey(prefix);
        while (key != null && key.startsWith(prefix)) {
            result += map.get(key);
            key = map.higherKey(key);
        }

        return result;
    }
}
