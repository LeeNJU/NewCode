package BreadthFirstSearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//题目描述:给定起始字符串"0000",每次改变其中的一个字符，加1或者减1，进行变换，是否能够变换成target字符串，例如deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//解法描述:bfs

public class OpentheLock {

    public int openLock(String[] deadends, String target) {
        int level = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.add("0000");
        Set<String> visited = new HashSet<String>();
        Set<String> deadSet = new HashSet<String>();
        Arrays.stream(deadends)
                .forEach(str -> deadSet.add(str));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String string = queue.poll();
                if (string.equals(target)) {
                    return level;
                }

                if (deadSet.contains(string) || visited.contains(string)) {
                    continue;
                }

                visited.add(string);
                char[] chars = string.toCharArray();
                for (int j = 0; j < chars.length; ++j) {
                    char prev = chars[j];
                    chars[j] = chars[j] < '9' ? ++chars[j] : '0';
                    String str = new String(chars);
                    queue.add(str);

                    chars[j] = prev;
                    chars[j] = chars[j] == '0' ? '9' : --chars[j];
                    str = new String(chars);
                    queue.add(str);

                    chars[j] = prev;
                }
            }
            ++level;
        }

        return -1;
    }
}
