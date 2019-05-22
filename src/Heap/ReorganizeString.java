package Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

//题目描述:给定一个字符串，进行重新排列，使得相邻的字符不同，例如S = "aab"，返回"aba"，S = "aaab"，返回""因为无法重新排列满足要求
//解法描述:出现次数最大的字符的频率不能超过字符串的一般，然后根据字符的频率用堆排序，每次去次数最大的两个字符

public class ReorganizeString {

    public String reorganizeString(String S) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.get(c) > (S.length() + 1) / 2) {
                return "";
            }
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        map.keySet()
                .stream()
                .forEach(key -> queue.add(key));

        StringBuilder stringBuilder = new StringBuilder();

        // 每次取最大的两个字符
        while (queue.size() > 1) {

            Character character1 = queue.poll();
            Character character2 = queue.poll();

            stringBuilder.append(character1)
                    .append(character2);

            map.put(character1, map.get(character1) - 1);
            map.put(character2, map.get(character2) - 1);

            if (map.get(character1) > 0) {
                queue.add(character1);
            }

            if (map.get(character2) > 0) {
                queue.add(character2);
            }
        }

        if (!queue.isEmpty()) {
            stringBuilder.append(queue.poll());
        }

        return stringBuilder.toString();
    }
}
