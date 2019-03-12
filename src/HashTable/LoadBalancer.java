package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//题目描述:设计一种数据结构来模拟load balancer，add可以添加一个server，remove可以删除一个server，pick随机返回一个server，要求概率相等，每个操作是O(1)
//解法描述:常数时间，必然是hashmap

public class LoadBalancer {

    private List<Integer> servers;
    private Map<Integer, Integer> map;
    private Random random;

    public LoadBalancer() {
        servers = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public void add(int server_id) {
        if (!map.containsKey(server_id)) {
            servers.add(server_id);
            map.put(server_id, servers.size() - 1);
        }
    }

    public void remove(int server_id) {
        // 与最后一个元素交换
        if (map.containsKey(server_id)) {
            int index = map.get(server_id);
            map.remove(server_id);
            map.put(servers.get(servers.size() - 1), index);
            servers.set(index, servers.get(servers.size() - 1));
            servers.remove(servers.size() - 1);
        }
    }

    public int pick() {
        return servers.get(random.nextInt(servers.size()) % servers.size());
    }
}
