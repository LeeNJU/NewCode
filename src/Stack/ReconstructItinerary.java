package Stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

//题目描述:给定一个行程，每一个点代表一个ticket，包含出发点和到达点，现在要重建整个行程，例如[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//        ["JFK","ATL","JFK","SFO","ATL","SFO"]是一个正确的行程，可能会有多个答案，例如["JFK","SFO","ATL","JFK","ATL","SFO"]也满足要求，那就返回字典序最小的
//        起点一定是JFK，并且保证有解
//解法描述:本质上是欧拉一笔画的问题，先生成一个图，并且排序，用栈来模拟访问的顺序，从起点JFK开始，遍历每一个节点并且放到栈中，如果从当前节点出发会碰到死节点，那么一定有一个环
//        会回到当前节点

public class ReconstructItinerary {

    // 递归写法
    // void visit(String airport) {
    // while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
    // visit(targets.get(airport).poll());
    // route.add(0, airport);
    // }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        tickets.stream()
                .forEach(ticket -> map.computeIfAbsent(ticket.get(0), key -> new PriorityQueue<String>())
                        .add(ticket.get(1)));

        List<String> result = new LinkedList<String>();

        Stack<String> stack = new Stack<String>();
        stack.add("JFK");
        while (!stack.isEmpty()) {
            final String current = stack.peek();
            if (!map.getOrDefault(current, new PriorityQueue<String>())
                    .isEmpty()) {
                stack.add(map.get(current)
                        .poll());
            } else {
                result.add(0, stack.pop());
            }
        }

        return result;
    }
}
