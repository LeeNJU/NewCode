package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//题目描述:给定一堆process，表示process之间的关系，每个进程有父进程，给定一个进程id，杀死该进程以及所有的子进程
//解法描述:bfs

public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < ppid.size(); ++i) {
            List<Integer> children = map.getOrDefault(ppid.get(i), new ArrayList<Integer>());
            children.add(pid.get(i));
            map.put(ppid.get(i), children);
        }

        List<Integer> result = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            map.getOrDefault(node, new ArrayList<Integer>())
                    .stream()
                    .forEach(num -> queue.add(num));
        }

        return result;
    }
}
