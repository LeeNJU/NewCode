package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//题目描述:给定二维数组表示公交路线，routes = [[1, 2, 7], [3, 6, 7]]，1-2-7-1-2-7...再给定起点S和终点T，判断最小需要坐几次公交车才能到达T
//解法描述:bfs，把公交车站分成一次可达，二次可达，

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < routes.length; ++i) {
            for (int j = 0; j < routes[i].length; ++j) {
                List<Integer> list = graph.getOrDefault(routes[i][j], new ArrayList<Integer>());
                list.add(i);
                graph.put(routes[i][j], list);
            }
        }

        HashSet<Integer> visited = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(S);

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int stop = queue.poll();
                if (stop == T) {
                    return level;
                }

                List<Integer> buses = graph.get(stop);
                buses.stream()
                        .filter(bus -> !visited.contains(bus))
                        .forEach(bus -> {
                            visited.add(bus);

                            for (int j = 0; j < routes[bus].length; ++j) {
                                queue.add(routes[bus][j]);
                            }
                        });
            }

            ++level;
        }

        return -1;
    }
}
