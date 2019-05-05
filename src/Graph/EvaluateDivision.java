package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import javafx.util.Pair;

//题目描述:给定一组A / B = k的表达式，表示A和B之间的倍数关系，然后给定一组C / D形式的query，求出C和D之间的
//        倍数关系。例如给定a / b = 2.0, b / c = 3.0，求出这些query的值
//        a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//解法描述:用图来表示倍数关系，然后从query的起始字符串开始深搜

public class EvaluateDivision {

    // dfs的含义是current除以end的值，-1表示值不存在
    private double dfs(String current, String end, Map<String, List<Pair<String, Double>>> graph, Set<String> visited) {
        if (current.equals(end)) {
            return 1.0;
        }

        if (visited.contains(current)) {
            return -1.0;
        }

        visited.add(current);
        List<Pair<String, Double>> list = graph.getOrDefault(current, new ArrayList<>());
        for (Pair<String, Double> pair : list) {
            double result = dfs(pair.getKey(), end, graph, visited);
            if (result != -1.0) {
                return pair.getValue() * result;
            }
        }

        visited.remove(current);
        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 建立图
        Map<String, List<Pair<String, Double>>> graph = new HashMap<String, List<Pair<String, Double>>>();
        IntStream.range(0, equations.size())
                .forEach(index -> {
                    List<Pair<String, Double>> list = graph.getOrDefault(equations.get(index)
                            .get(0), new ArrayList<Pair<String, Double>>());
                    list.add(new Pair<String, Double>(equations.get(index)
                            .get(1), values[index]));
                    graph.put(equations.get(index)
                            .get(0), list);

                    list = graph.getOrDefault(equations.get(index)
                            .get(1), new ArrayList<Pair<String, Double>>());
                    list.add(new Pair<String, Double>(equations.get(index)
                            .get(0), 1 / values[index]));
                    graph.put(equations.get(index)
                            .get(1), list);
                });

        double[] result = new double[queries.size()];
        IntStream.range(0, result.length)
                .forEach(index -> {
                    // 不包含的字符串
                    if (!graph.containsKey(queries.get(index)
                            .get(0)) || !graph.containsKey(
                                    queries.get(index)
                                            .get(1))) {
                        result[index] = -1.0;
                        return;
                    }

                    Set<String> visited = new HashSet<String>();
                    result[index] = dfs(queries.get(index)
                            .get(0),
                            queries.get(index)
                                    .get(1),
                            graph, visited);
                });

        return result;
    }
}
