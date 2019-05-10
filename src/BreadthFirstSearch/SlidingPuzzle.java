package BreadthFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//题目描述:给定一个2*3的字符数组，只包含0,1,2,3,4,5几个字符,每一步只能把0和其相邻的字符交换，得到下一个字符数组，求最少需要几步可以得到[[1,2,3],[4,5,0]]
//解法描述:本质就是bfs，把字符数组序列化成字符串，然后bfs

public class SlidingPuzzle {

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
        return new String(chars);
    }

    public int slidingPuzzle(int[][] board) {
        String s = "" + board[0][0] + board[0][1] + board[0][2] + board[1][0] + board[1][1] + board[1][2];
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.add(s);
        visited.add(s);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int a = 0; a < size; ++a) {
                s = queue.poll();
                if (s.equals("123450")) {
                    return step;
                }

                int index = s.indexOf('0');
                int i = index / 3;
                int j = index % 3;

                int[] dx = { 1, -1, 0, 0 };
                int[] dy = { 0, 0, 1, -1 };
                for (int k = 0; k < dx.length; ++k) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if (x < 0 || y < 0 || x > 1 || y > 2) {
                        continue;
                    }

                    String next = swap(s, x * 3 + y, i * 3 + j);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }

            ++step;
        }

        return -1;
    }
}
