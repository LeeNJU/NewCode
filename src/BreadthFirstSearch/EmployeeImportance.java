package BreadthFirstSearch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Util.Employee;

//题目描述:给定一个Employee的结构,[id, importance, [subordinates]]和某一个employee的id,求出importance的和
//解法描述:bfs

public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> graph = new HashMap<Integer, Employee>();
        employees.stream()
                .forEach(employee -> graph.putIfAbsent(employee.id, employee));

        int result = 0;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(id);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            result += graph.get(node).importance;

            for (Integer child : graph.get(node).subordinates) {
                queue.add(child);
            }
        }

        return result;
    }
}
