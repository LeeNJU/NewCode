package DepthFirstSearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//题目描述:给定一个起始字符串start和终止字符串，以及一串转移规则，判断start能否经过一系列转换得到end，例如["S → abc", "S → aA", "A → b", "A → c"], startSymbol = S,
// symbolString = “ac”, return True.
//解法描述:递归

public class Parser {

    private boolean dfs(String start, String end, HashMap<String, Set<String>> map, Set<String> visited) {
        if (start.equals(end)) {
            return true;
        }

        if (visited.contains(start) || start.length() > end.length()) {
            return false;
        }

        visited.add(start);
        for (int i = 0; i < start.length(); ++i) {
            String s = start.substring(i, i + 1);

            Set<String> set = map.getOrDefault(s, new HashSet<String>());
            String first = start.substring(0, i);
            String last = start.substring(i + 1);
            if (set.stream()
                    .anyMatch(str -> dfs(first + str + last, end, map, visited))) {
                return true;
            }
        }
        visited.remove(start);

        return false;
    }

    public boolean canBeGenerated(String[] generator, char startSymbol, String symbolString) {
        HashMap<String, Set<String>> map = new HashMap<String, Set<String>>();
        Arrays.stream(generator)
                .forEach(s -> {
                    int index = s.indexOf(" -> ");
                    String key = s.substring(0, index);
                    String value = s.substring(index + 4);
                    Set<String> set = map.getOrDefault(key, new HashSet<String>());
                    set.add(value);
                    map.put(key, set);
                });

        Set<String> visited = new HashSet<String>();
        return dfs(String.valueOf(startSymbol), symbolString, map, visited);
    }
}
